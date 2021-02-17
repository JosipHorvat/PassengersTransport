package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.repositories.OperatorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


@SpringBootTest
class OperatorServiceImplTest {

    OperatorServiceImpl operatorServiceImpl;

    @Mock
    OperatorRepository operatorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        operatorServiceImpl = new OperatorServiceImpl(operatorRepository);
    }

    @Test
    void getOperators() {
        Operator operator = new Operator();
        HashSet operatorData = new HashSet();
        operatorData.add(operator);

        when(operatorRepository.findAll()).thenReturn(operatorData);

        Set<Operator> operators = operatorServiceImpl.getOperators();
        assertEquals(operators.size(),1);

        verify(operatorRepository, times(1)).findAll();
    }
}