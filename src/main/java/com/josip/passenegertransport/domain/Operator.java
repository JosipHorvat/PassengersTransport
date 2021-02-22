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

    @Builder
    public Operator(Long id, String firstName, String lastName, String oib, String email, String password, String role) {
        super(id, firstName, lastName, oib, email);
        this.password = password;
        this.role = role;
    }

    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    //TODO: Operator needs to be: role-ENUM of administrator and user  (Not sure this is going to be final case)
    //TODO: Administrator have access to everything, user only to certain pages. Admin can delete users
    //TODO: Operator need to have USER login page,
    //TODO: Operator Register and confirm password validation
    //TODO: Pasdword need to be BCrypted in database

}
