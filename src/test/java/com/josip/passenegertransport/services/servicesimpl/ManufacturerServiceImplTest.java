package com.josip.passenegertransport.services.servicesimpl;

import com.josip.passenegertransport.domain.Manufacturer;
import com.josip.passenegertransport.exceptions.NotFoundException;
import com.josip.passenegertransport.repositories.ManufacturerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

//  ovdje koristim JUNIT 4
 public class ManufacturerServiceImplTest {

    ManufacturerServiceImpl manufacturerService;

    @Mock
    ManufacturerRepository manufacturerRepository;

    @Before
   public void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);

        manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);
    }

    @Test(expected = NotFoundException.class)
    public void getManufacturerByIdNotFound() throws Exception{

        Optional<Manufacturer> manufacturerOptional = Optional.empty();
        when(manufacturerRepository.findById(anyLong())).thenReturn(manufacturerOptional);
        Manufacturer manufacturerReturned = manufacturerService.findById(1L);
    }

}