package com.josip.passenegertransport.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "indebted_vehicle")
public class IndebtedVehicle extends BaseEntity{

    public IndebtedVehicle(Long id, LocalDate vehicleIndebted, LocalDate vehicleDischarged,
                           Vehicle vehicle, Driver driver) {
        super(id);
        this.vehicleIndebted = vehicleIndebted;
        this.vehicleDischarged = vehicleDischarged;
        this.vehicle = vehicle;
        this.driver = driver;
    }

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate vehicleIndebted;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate vehicleDischarged;

    @ManyToOne
    @JoinColumn(name= "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name= "driver_id")
    private Driver driver;
}
