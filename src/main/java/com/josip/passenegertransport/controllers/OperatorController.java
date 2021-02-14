package com.josip.passenegertransport.controllers;


import com.josip.passenegertransport.services.OperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class OperatorController {

    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }


    @RequestMapping({"", "/", "/index"})
    public String getAllOperators(Model model){
        log.debug("I am listing all operators");
        model.addAttribute("operators", operatorService.getOperators());
        return "index";
    }
}
