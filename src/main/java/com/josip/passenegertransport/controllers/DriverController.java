package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.domain.Driver;
import com.josip.passenegertransport.services.DriverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@AllArgsConstructor
public class DriverController {

    @Autowired
    private final DriverService driverService;

    @RequestMapping("drivers")
    public String getIndexPage(Model model) {
        log.debug("Getting driver index page");
        model.addAttribute("drivers", driverService.getDrivers());

        return "driver/list";
    }

    @GetMapping("/driver/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("drivers", driverService.findById(Long.valueOf(id)));
        return "driver/show";
    }

    //Add Driver
    @PostMapping(value="drivers/addNew")
    public String addNew(Driver driver) {
        driverService.saveDriver(driver);

        log.debug("I am in Driver Controller -Add new");
        return "redirect:/drivers";
    }

    @GetMapping("driver/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("driver", driverService.findById(Long.valueOf(id)));

        return "driver/driverform";
    }

    @PostMapping("driver")
    public String saveOrUpdate(@ModelAttribute Driver driver) {
        Driver savedDriver = driverService.saveDriver(driver);

        return "redirect:/driver/" + savedDriver.getId() + "/show";
    }

    @GetMapping("driver/{id}/delete")
    public String deleteById(@PathVariable String id){
        driverService.deleteById(Long.valueOf(id));
        log.debug("Deleted by ID: " + id);

        return "redirect:/drivers";
    }
}
