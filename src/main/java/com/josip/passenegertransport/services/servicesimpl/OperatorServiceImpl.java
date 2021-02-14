package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.repositories.OperatorRepository;
import com.josip.passenegertransport.services.OperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;

    public OperatorServiceImpl(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public Set<Operator> getOperators() {
        log.debug("I am in operator service impl");
        Set<Operator> operatorSet = new HashSet<>();
        operatorRepository.findAll().iterator().forEachRemaining(operatorSet::add);
        return operatorSet;
    }
}