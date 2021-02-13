package com.josip.passenegertransport.repositories;

import com.josip.passenegertransport.domain.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long> {
}
