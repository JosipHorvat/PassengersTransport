package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Manufacturer;
import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.repositories.ManufacturerRepository;
import com.josip.passenegertransport.services.ManufacturerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public Set<Manufacturer> getManufacturers() {
        log.debug("I am in manufacturer service impl");
        Set<Manufacturer> manufacturerSet = new HashSet<>();
        manufacturerRepository.findAll().iterator().forEachRemaining(manufacturerSet::add);
        return manufacturerSet;
    }

    @Override
    public Manufacturer findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long idToDelete) {

    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return null;
    }
}
