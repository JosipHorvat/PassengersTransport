package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Vehicle;
import com.josip.passenegertransport.repositories.VehicleRepository;
import com.josip.passenegertransport.services.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    // I am using different way of service impl here.

    @Autowired
    private  VehicleRepository vehicleRepository;

    @Override
    public Set<Vehicle> getVehicles() {
        log.debug("I am in vehicle service impl getVehicles");
        Set<Vehicle> vehicleSet = new HashSet<>();
        vehicleRepository.findAll().iterator().forEachRemaining(vehicleSet::add);
        return vehicleSet;
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        log.debug("I am in vehicle service impl findById");
        return vehicleRepository.findById(id);
    }

    @Override
    public void deleteById(Long idToDelete) {
    log.debug("I am in vehicle service impl deleteById");
    vehicleRepository.deleteById(idToDelete);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        log.debug("I am in vehicle service impl save");
        return vehicleRepository.save(vehicle);
    }
}
