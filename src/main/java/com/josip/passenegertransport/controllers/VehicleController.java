package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.domain.Manufacturer;
import com.josip.passenegertransport.domain.Vehicle;
import com.josip.passenegertransport.services.ManufacturerService;
import com.josip.passenegertransport.services.VehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Controller
@AllArgsConstructor
public class VehicleController {

    @Autowired private final VehicleService vehicleService;
    @Autowired private final ManufacturerService manufacturerService;

    //Get all vehicles
    @GetMapping("vehicles")
    public String findAll(Model model){
        Set<Vehicle> vehicleSet = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleSet);

        Set<Manufacturer> manufacturerSet = manufacturerService.getManufacturers();
        model.addAttribute("manufacturers", manufacturerSet);

        log.debug("Getting vehicles main page");
        return "vehicle/vehicle";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(Long id)
    {
        return vehicleService.findById(id);
    }

    //Add Vehicle
    @PostMapping(value="vehicles/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);

        log.debug("I am in Vehicle Controller -Add new");
        return "redirect:/vehicles";
    }

    @RequestMapping(value="vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);

        log.debug("I am in Vehicle Controller -update");
        return "redirect:/vehicles";
    }

    @RequestMapping(value="vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        vehicleService.deleteById(id);

        log.debug("I am in Vehicle Controller -delete");
        return "redirect:/vehicles";
    }

}
