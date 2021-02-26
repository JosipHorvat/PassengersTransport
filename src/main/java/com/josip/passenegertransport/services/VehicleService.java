package com.josip.passenegertransport.services;

import com.josip.passenegertransport.domain.Vehicle;

import java.util.Optional;
import java.util.Set;

public interface VehicleService {

    //list of
    Set<Vehicle> getVehicles();
    //find byId
    Optional<Vehicle> findById(Long id);
    //deleteById
    void deleteById(Long idToDelete);
    //update/save
    Vehicle save(Vehicle vehicle);
}
