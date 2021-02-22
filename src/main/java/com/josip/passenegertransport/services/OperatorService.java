package com.josip.passenegertransport.services;

import com.josip.passenegertransport.domain.Operator;

import java.util.Set;

public interface OperatorService {
    //list of
    Set<Operator> getOperators();
    //find byId
    Operator findById(Long id);
    //deleteById
    void deleteById(Long idToDelete);
    //update/save
    Operator save(Operator operator);


}
