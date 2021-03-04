package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Driver;
import com.josip.passenegertransport.repositories.DriverRepository;
import com.josip.passenegertransport.services.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Set<Driver> getDrivers() {
        log.debug("I am in Driver service impl");
        Set<Driver> driverSet = new HashSet<>();
        driverRepository.findAll().iterator().forEachRemaining(driverSet::add);
        return driverSet;
    }

    @Override
    public Driver findById(Long id) {
        log.debug("I am in driver service impl findById");
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if(!driverOptional.isPresent()){
            throw new RuntimeException("Driver not found");
        }
        return driverOptional.get();
    }

    @Override
    public Driver saveDriver(Driver driver) {
        log.debug("I am in driver service impl SAVING...");
        return driverRepository.save(driver);
    }

    @Override
    public void deleteById(Long idToDelete) {
        log.debug("I am in driver service impl DELETING byId...");
        driverRepository.deleteById(idToDelete);
    }
}
