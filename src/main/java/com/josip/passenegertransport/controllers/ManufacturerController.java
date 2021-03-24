package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.domain.Manufacturer;
import com.josip.passenegertransport.exceptions.NotFoundException;
import com.josip.passenegertransport.services.ManufacturerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
@AllArgsConstructor
public class ManufacturerController {

 @Autowired private final ManufacturerService manufacturerService;


    @GetMapping("/manufacturer/{id}/show")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("manufacturer", manufacturerService.findById(Long.valueOf(id)));

        return "manufacturer/show";
    }

    @RequestMapping({"", "/", "/manufacturers"})
    public String getAllManufacturers(Model model){
        log.debug("I am listing all manufacturers");
        model.addAttribute("manufacturers", manufacturerService.getManufacturers());
        return "manufacturer/manufacturers";
    }

    @RequestMapping("manufacturers/findById")
    @ResponseBody
    public Manufacturer findById(Long id) {
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(){

        log.error("Handling not found exception");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404Error");

        return modelAndView;
    }
}
