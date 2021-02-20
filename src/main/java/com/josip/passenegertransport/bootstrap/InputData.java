package com.josip.passenegertransport.bootstrap;

import com.github.javafaker.Faker;
import com.josip.passenegertransport.domain.*;
import com.josip.passenegertransport.repositories.DriverRepository;
import com.josip.passenegertransport.repositories.ManufacturerRepository;
import com.josip.passenegertransport.repositories.OperatorRepository;
import com.josip.passenegertransport.repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.math.BigDecimal.TEN;

@Slf4j
@Component
public class InputData implements ApplicationListener<ContextRefreshedEvent> {

    private final OperatorRepository operatorRepository;
    private final VehicleRepository vehicleRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final DriverRepository driverRepository;

    public InputData(OperatorRepository operatorRepository, VehicleRepository vehicleRepository, ManufacturerRepository manufacturerRepository, DriverRepository driverRepository) {
        this.operatorRepository = operatorRepository;
        this.vehicleRepository = vehicleRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.driverRepository = driverRepository;
    }

    Faker faker = new Faker();

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("***********************************************************");
        log.debug("****************LOADING DATA FROM BOOTSTRAP****************");
        log.debug("***********************************************************");

        if(!operatorRepository.findAll().equals(0)){
            log.debug("Loading operators");
            operatorRepository.saveAll(getOperators());
        }
        if(manufacturerRepository.findAll().equals(0)){
            log.debug("Loading Manufacturers & Vehicles");
            manufacturerRepository.saveAll(getManufacturers());
        }
        if(driverRepository.findAll().equals(0)){
            driverRepository.saveAll(getDrivers());
            log.debug("Loading Drivers & certain driver current transport of passengers");
        }

    }

    private List<Operator> getOperators() {

        List<Operator> operators = new ArrayList<>(2);

        Operator user = new Operator();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setRole("user");
        user.setEmail("user@gmail.com");
        user.setOib("123345667889");
        user.setPassword("user1");
        operators.add(user);

        Operator admin = new Operator();
        admin.setFirstName(faker.name().firstName());
        admin.setLastName(faker.name().lastName());
        admin.setRole("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setOib("123345667889");
        admin.setPassword("admin1");
        operators.add(admin);

        return operators;
    }

    private List<Manufacturer> getManufacturers() {

        List<Manufacturer> manufacturers = new ArrayList<>();
        Manufacturer randomCompany;

            randomCompany = new Manufacturer();
            randomCompany.setCountry(faker.country().name());
            randomCompany.setAddress(faker.address().fullAddress());
            randomCompany.setNameOfCompany(faker.name().username());
            randomCompany.setWebSite(faker.internet().url());
            randomCompany.setTelephone(faker.phoneNumber().cellPhone());

            Set<Vehicle> vehicles = new HashSet<>();

            Vehicle opel = new Vehicle();
        opel.setName("opel");
        opel.setRegistrationPlate("OS-"+ faker.number().randomNumber());
        opel.setManufacturer(randomCompany);
        opel.setTotalKilometersPassed(TEN);
        opel.setNumberOfSeats(4);
        opel.setDateOfManufacturing(LocalDate.now());
        opel.setModel("corsa");
        opel.setInsurance(true);

            vehicles.add(opel);

            randomCompany.setVehicles(vehicles);

            manufacturers.add(randomCompany);

        return manufacturers;
    }

    private List<Driver> getDrivers(){
    List<Driver>  drivers  = new ArrayList<>();
        Driver josip = new Driver();
        josip.setFirstName("Josip");
        josip.setLastName("Horvat");
        josip.setTelephone("0838760974");
        josip.setEmail("josiph988@gmail.com");
        josip.setOib("1233456667");
        josip.setDateOfBirth(LocalDate.now());
        josip.setVerified(true);

       Set<PassengersTransport>  passengersTransports = new HashSet<>();
        for (int i = 0; i <5 ; i++) {
            PassengersTransport josipsPassengersTransport = new PassengersTransport();
            josipsPassengersTransport.setDriver(josip);
            josipsPassengersTransport.setNumberOfPassengers(4);
            josipsPassengersTransport.setDate(LocalDate.now());
            josipsPassengersTransport.setPrice(TEN);
            josipsPassengersTransport.setStartingAddress(faker.address().streetAddress());
            josipsPassengersTransport.setArrivalAddress(faker.address().streetAddress());
            passengersTransports.add(josipsPassengersTransport);
        }

        josip.setPassengersTransports(passengersTransports);

        drivers.add(josip);
        return drivers;
    }
}
