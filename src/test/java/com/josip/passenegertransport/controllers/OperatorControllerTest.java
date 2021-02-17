package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.services.OperatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
class OperatorControllerTest {

    @Mock
    OperatorService operatorService;

    @InjectMocks
    OperatorController operatorController;

    Set<Operator> operators;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);

        operators = new HashSet<>();
        operators.add(Operator.builder().id(1L).build());
        operators.add(Operator.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(operatorController).build();
    }

    @Test
    void getAllOperators() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("operators"));


    }
}