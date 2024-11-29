package co.develhope.vehicle;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
