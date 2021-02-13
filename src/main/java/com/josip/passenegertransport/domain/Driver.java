package com.josip.passenegertransport.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver extends Person{


    public Driver(Long id, String firstName, String lastName, String oib, String email, Boolean verified,
                  LocalDate dateOfBirth, String telephone, Set<PassengersTransport> passengersTransports,
                  Set<IndebtedVehicle> indebtedVehicles, Byte[] image) {
        super(id, firstName, lastName, oib, email);
        this.verified = verified;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.image = image;
        if(passengersTransports != null){
            this.passengersTransports = passengersTransports;
        }
        if(indebtedVehicles != null){
            this.indebtedVehicles = indebtedVehicles;
        }

    }

    private Boolean verified;
    private String telephone;

    @Lob
    private Byte[] image;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private Set<PassengersTransport> passengersTransports = new HashSet<>();

   @OneToMany( cascade = CascadeType.ALL,mappedBy = "driver")
    private Set<IndebtedVehicle> indebtedVehicles = new HashSet<>();
}
