package com.josip.passenegertransport.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle extends BaseEntity{

    public Vehicle(Long id, String name, String model, String registrationPlate, Boolean insurance,
                   BigDecimal totalKilometersPassed, LocalDate dateOfManufacturing, Integer numberOfSeats,
                   Set<IndebtedVehicle> indebtedVehicles, Manufacturer manufacturer) {
        super(id);
        this.name = name;
        this.model = model;
        this.registrationPlate = registrationPlate;
        this.insurance = insurance;
        this.totalKilometersPassed = totalKilometersPassed;
        this.dateOfManufacturing = dateOfManufacturing;
        this.numberOfSeats = numberOfSeats;
        if(indebtedVehicles == null || indebtedVehicles.size() > 0){
            this.indebtedVehicles = indebtedVehicles;
        }
        this.manufacturer = manufacturer;
    }

    private String name;
    private String model;
    private String registrationPlate;
    private Boolean insurance;
    private BigDecimal totalKilometersPassed;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfManufacturing;
    private Integer numberOfSeats;

    @OneToMany(mappedBy = "vehicle")
    private Set<IndebtedVehicle> indebtedVehicles = new HashSet<>();

    @ManyToOne
    private Manufacturer manufacturer;
}
