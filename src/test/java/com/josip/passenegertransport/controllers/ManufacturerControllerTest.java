package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.exceptions.NotFoundException;
import com.josip.passenegertransport.services.ManufacturerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;

//I  USED JUNIT4 HERE!!!!!
public class ManufacturerControllerTest {

    @Mock
    ManufacturerService manufacturerService;

    ManufacturerController manufacturerController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        manufacturerController = new ManufacturerController(manufacturerService);
        mockMvc = MockMvcBuilders.standaloneSetup(manufacturerController).build();
    }

    @Test
    public void testGetManufacturerNotFound() throws Exception{

        when(manufacturerService.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/manufacturer/55/show"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("404Error"));
    }
    @Test
    public void testGetManufacturerNumberFormatException() throws Exception{

        mockMvc.perform(get("/manufacturer/abcd/show"))
                .andExpect(status().isBadRequest())
                .andExpect(view().name("400Error"));
    }
}