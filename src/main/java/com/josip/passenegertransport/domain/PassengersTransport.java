package com.josip.passenegertransport.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "passengers_transport")
public class PassengersTransport extends BaseEntity {

    private String startingAddress;
    private String arrivalAddress;
    private BigDecimal totalKilometers;
    private BigDecimal price;
    private Integer numberOfPassengers;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    Driver driver;

}
