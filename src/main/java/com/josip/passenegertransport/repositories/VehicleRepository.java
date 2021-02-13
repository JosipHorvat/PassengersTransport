package com.josip.passenegertransport.repositories;

import com.josip.passenegertransport.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
