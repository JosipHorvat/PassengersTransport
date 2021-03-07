package com.josip.passenegertransport.controllers;

import com.josip.passenegertransport.dto.RegistrationRequest;
import com.josip.passenegertransport.services.servicesimpl.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping(path = "/form")
    public String registerForm(Model model) {

        model.addAttribute("registrationRequest", new RegistrationRequest("","","",""));

        return "registration/form";
    }

    @PostMapping
    public String register(RegistrationRequest registrationRequest) {

        registrationService.register(registrationRequest);

        return "redirect:/registration/form";
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return  "redirect:/login";
    }

}