package com.josip.passenegertransport.controllers;


import com.josip.passenegertransport.domain.Operator;
import com.josip.passenegertransport.services.OperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class OperatorController {

    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }


    @RequestMapping({"", "/", "/operators"})
    public String getAllOperators(Model model){
        log.debug("I am listing all operators");
        model.addAttribute("operators", operatorService.getOperators());
        return "operator/operator";
    }

    @GetMapping("/operator/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("operator", operatorService.findById(Long.valueOf(id)));
        return "operator/show";
    }

    @GetMapping("operator/{id}/delete")
    public String deleteById(@PathVariable String id){
        operatorService.deleteById(Long.valueOf(id));
        log.debug("Deleted by ID: " + id);

        return "redirect:/operators";
        // After deleting i am going back to list of operators
    }

    @PostMapping(value = "operators/add")
    public String addNewOperator(Operator operator){
        operatorService.save(operator);
        return "redirect:/operators";
    }

}
