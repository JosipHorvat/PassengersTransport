package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Manufacturer;
import com.josip.passenegertransport.exceptions.NotFoundException;
import com.josip.passenegertransport.repositories.ManufacturerRepository;
import com.josip.passenegertransport.services.ManufacturerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    public Set<Manufacturer> getManufacturers() {
        log.debug("I am in manufacturer service impl");
        Set<Manufacturer> manufacturerSet = new HashSet<>();
        manufacturerRepository.findAll().iterator().forEachRemaining(manufacturerSet::add);
        return manufacturerSet;
    }

    @Override
    public Manufacturer findById(Long id) {
        Optional<Manufacturer> manufacturerOptional = manufacturerRepository.findById(id);

        if(!manufacturerOptional.isPresent()){
            throw new NotFoundException("Manufacturer not found!!");
        }

        return manufacturerOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
    manufacturerRepository.deleteById(idToDelete);
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }
}
