package com.josip.passenegertransport.services;

import com.josip.passenegertransport.domain.Operator;

import java.util.Set;

public interface OperatorService {

    Set<Operator> getOperators();

    Operator findById(Long id);
}
