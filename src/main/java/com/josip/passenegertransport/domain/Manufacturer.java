package com.josip.passenegertransport.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "manufacturer")
public class Manufacturer extends BaseEntity{

    public Manufacturer(Long id, String nameOfCompany, String webSite, String country,
                        String address, String telephone, Set<Vehicle> vehicles) {
        super(id);
        this.nameOfCompany = nameOfCompany;
        this.webSite = webSite;
        this.country = country;
        this.address = address;
        this.telephone = telephone;
        this.vehicles = vehicles;
    }

    private String nameOfCompany;
    private String webSite;
    private String country;
    private String address;
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    private Set<Vehicle> vehicles = new HashSet<>();
}
