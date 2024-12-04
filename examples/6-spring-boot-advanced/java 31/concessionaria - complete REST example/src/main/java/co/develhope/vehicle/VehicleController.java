package co.develhope.vehicle;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @GetMapping("")
    public Iterable<VehicleDTO> getAllVehicles(@RequestHeader(name = "Cache-Control") String cache) {
        List<VehicleEntity> vehicles = vehicleRepository.findAll();
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        for (VehicleEntity vehicle: vehicles) {
            VehicleDTO dto = new VehicleDTO(vehicle);
            vehicleDTOs.add(dto);
        }

        return vehicleDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@RequestHeader HttpHeaders headers, @PathVariable long id) {
        try {
            VehicleEntity vehicle = vehicleRepository.getReferenceById(id);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("X-Custom-header", "Ciao");

            return ResponseEntity.ok().headers(responseHeaders).body(new VehicleDTO(vehicle));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<VehicleDTO> createVehicle(@Valid @RequestBody CreateVehicleDTO request) {
        VehicleEntity newVehicle = vehicleRepository.save(new VehicleEntity(request.azienda, request.colore, request.modello, request.prezzo, request.tipo));
        return ResponseEntity.status(HttpStatus.CREATED).body(new VehicleDTO(newVehicle));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable long id, @Valid @RequestBody UpdateVehicleDTO request) {
        VehicleEntity vehicle = vehicleRepository.getReferenceById(id);
        if (request.azienda != null && !request.azienda.isBlank()) {
            vehicle.setAzienda(request.azienda);
        }
        if (request.colore != null && !request.colore.isBlank()) {
            vehicle.setColore(request.colore);
        }
        if (request.modello != null && !request.colore.isBlank()) {
            vehicle.setModello(request.modello);
        }
        if (request.prezzo != null && request.prezzo > 0) {
            vehicle.setPrezzo(request.prezzo);
        }
        if (request.tipo != null) {
            vehicle.setTipo(request.tipo);
        }

        VehicleEntity updatedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(new VehicleDTO(updatedVehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVehicle(@PathVariable long id) {
        try {
            VehicleEntity vehicle = vehicleRepository.getReferenceById(id);
            logger.debug(vehicle.toString());
            vehicleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
