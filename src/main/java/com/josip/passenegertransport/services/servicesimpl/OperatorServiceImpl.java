package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.repositories.OperatorRepository;
import com.josip.passenegertransport.services.OperatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;

    @Override
    public Set<Operator> getOperators() {
        log.debug("I am in operator service impl");
        Set<Operator> operatorSet = new HashSet<>();
        operatorRepository.findAll().iterator().forEachRemaining(operatorSet::add);
        return operatorSet;
    }

    @Override
    public Operator findById(Long id) {

        Optional<Operator> operatorOptional = operatorRepository.findById(id);
        if(!operatorOptional.isPresent()){
            throw new RuntimeException("Operator not found!");
        }
        return operatorOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        operatorRepository.deleteById(idToDelete);
    }

    @Override
    public Operator save(Operator operator) {
        return operatorRepository.save(operator);
    }
}
