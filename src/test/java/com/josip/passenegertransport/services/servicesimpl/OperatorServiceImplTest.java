package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.repositories.OperatorRepository;
import com.josip.passenegertransport.services.OperatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class OperatorServiceImplTest {

    @InjectMocks
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

    @Test
    void findById() throws Exception{
    Operator operator = new Operator();
    operator.setId(1L);
        Optional<Operator> operatorOptional = Optional.of(operator);

        when(operatorRepository.findById(anyLong())).thenReturn(operatorOptional);

        Operator operatorReturned = operatorServiceImpl.findById(1L);
        assertEquals(Long.valueOf(1L), operatorReturned.getId());
        verify(operatorRepository, times(1)).findById(anyLong());
    }

    @Test
    void deleteById() throws Exception{
            operatorServiceImpl.deleteById(1L);

        verify(operatorRepository).deleteById(anyLong());
    }
}