package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.domain.Manufacturer;
import com.josip.passenegertransport.services.ManufacturerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping({"", "/", "/manufacturers"})
    public String getAllManufacturers(Model model){
        log.debug("I am listing all manufacturers");
        model.addAttribute("manufacturers", manufacturerService.getManufacturers());
        return "manufacturer/manufacturers";
    }

    @RequestMapping("manufacturers/findById")
    @ResponseBody
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerService.findById(id);
    }

    @PostMapping(value = "manufacturers/add")
    public String addNewManufacturer(Manufacturer manufacturer){
        manufacturerService.save(manufacturer);
        log.debug("I am adding a new manufacturer");
        return "redirect:/manufacturers";
    }

    @RequestMapping(value="manufacturers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        log.debug("I updating existing operator");
        return "redirect:/manufacturers";
    }

    @RequestMapping(value = "manufacturers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Long id){
        manufacturerService.deleteById(id);
        log.debug("Deleted by ID: " + id);
        return "redirect:/manufacturers";
    }
}
