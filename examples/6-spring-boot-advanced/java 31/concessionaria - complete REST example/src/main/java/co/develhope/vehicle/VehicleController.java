package co.develhope.vehicle;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("")
    public Iterable<VehicleDTO> getAllVehicles() {
        List<VehicleEntity> vehicles = vehicleRepository.findAll();
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        for (VehicleEntity vehicle: vehicles) {
            VehicleDTO dto = new VehicleDTO(vehicle);
            vehicleDTOs.add(dto);
        }

        return vehicleDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable long id) {
        try {
            VehicleEntity vehicle = vehicleRepository.getReferenceById(id);
            return ResponseEntity.ok(new VehicleDTO(vehicle));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<VehicleDTO> createVehicle(@Valid @RequestBody CreateVehicleDTO request) {
        VehicleEntity newVehicle = vehicleRepository.save(new VehicleEntity(request.azienda, request.colore, request.modello, request.prezzo, request.tipo));
        return ResponseEntity.status(HttpStatus.CREATED).body(new VehicleDTO(newVehicle));
    }

}
