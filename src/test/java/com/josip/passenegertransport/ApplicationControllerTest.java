package com.josip.passenegertransport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
class ApplicationControllerTest {

    ApplicationController applicationController;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        applicationController = new ApplicationController();
    }

    @Test
    void goHome() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(applicationController).build();
        mockMvc.perform(get("/", "/", "/index"))
        .andExpect(status().isOk())
        .andExpect(view().name("izbornik"));
    }
}