package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.services.ManufacturerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping({"", "/", "/manufacturers"})
    public String getAllOperators(Model model){
        log.debug("I am listing all manufacturers");
        model.addAttribute("manufacturers", manufacturerService.getManufacturers());
        return "manufacturer/manufacturer";
    }
}
