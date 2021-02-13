package com.josip.passenegertransport.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operators")
public class Operator extends Person{


    public Operator(Long id, String firstName, String lastName, String oib, String email, String password, String role) {
        super(id, firstName, lastName, oib, email);
        this.password = password;
        this.role = role;
    }

    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

}
