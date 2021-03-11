package com.josip.passenegertransport.repositories;

import com.josip.passenegertransport.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

//    @Query("SELECT d FROM Driver  d WHERE d.email = ?1")
//    Optional<Driver> findDriverByEmail(String email);
}
