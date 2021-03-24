package com.josip.passenegertransport.services;


import com.josip.passenegertransport.domain.Manufacturer;

import java.util.Optional;
import java.util.Set;

public interface ManufacturerService {

    //list of
    Set<Manufacturer> getManufacturers();
    //find byId
    Manufacturer findById(Long id);
    //deleteById
    void deleteById(Long idToDelete);
    //update/save
    Manufacturer save(Manufacturer manufacturer);
}
