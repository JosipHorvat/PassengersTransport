package com.josip.passenegertransport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    public Person(Long id, String firstName, String lastName, String oib, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.email = email;
    }
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "oib")
    private String oib;
    @Column(name = "email")
    private String email;
}
