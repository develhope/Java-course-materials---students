package co.develhope.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/all")
    public Iterable<VehicleEntity> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("")
    public VehicleEntity getVehicle() {
        VehicleEntity newVehicle = new VehicleEntity("Honda", "rosso", "Corolla", 15000.0d, VehicleType.AUTO);
        vehicleRepository.save(newVehicle);
        return newVehicle;
    }

}
