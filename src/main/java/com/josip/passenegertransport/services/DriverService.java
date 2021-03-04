package com.josip.passenegertransport.services;

import com.josip.passenegertransport.domain.Driver;

import java.util.Set;

public interface DriverService {


    Set<Driver> getDrivers();

    Driver findById(Long id);

    Driver saveDriver(Driver driver);

    void deleteById(Long idToDelete);

}
