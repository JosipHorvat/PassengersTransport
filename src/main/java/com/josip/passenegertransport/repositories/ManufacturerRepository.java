package com.josip.passenegertransport.repositories;

import com.josip.passenegertransport.domain.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer,Long> {
}
