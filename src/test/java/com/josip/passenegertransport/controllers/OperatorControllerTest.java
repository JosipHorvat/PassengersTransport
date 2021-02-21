package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.services.OperatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;



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

        operatorController = new OperatorController(operatorService);
        mockMvc = MockMvcBuilders.standaloneSetup(operatorController).build();
    }

    @Test
    void getAllOperators() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("operator/operator"))
                .andExpect(model().attributeExists("operators"));
    }
    @Test
    void displayOperator() throws Exception{
       Operator  operator = new Operator();
        when(operatorService.findById(anyLong())).thenReturn(operator);

        mockMvc.perform(get("/operator/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("operator/show"))
                .andExpect(model().attributeExists("operator"));
    }
   @Test
    void deleteOperator() throws Exception {
       Long id =1L;

       mockMvc.perform(get("/operator/1/delete"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/operators"));
       verify(operatorService, times(1)).deleteById(id);
    }

}