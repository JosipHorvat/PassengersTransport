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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

// guru 235 Data validation, Zadnje sto sam uradio su anotacije za error handling


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

    @NotBlank
    @Size(min = 1, max = 100)
    private String nameOfCompany;

    @URL
    private String webSite;

    @NotBlank
    @Size(min = 1, max = 100)
    private String country;

    @NotBlank
    @Size(min = 1, max = 300)
    private String address;

    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    private Set<Vehicle> vehicles = new HashSet<>();
}
