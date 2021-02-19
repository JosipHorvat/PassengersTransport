package com.josip.passenegertransport;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping({"", "/", "/index"})
    public String goHome(){
        return "izbornik";
    }
}

