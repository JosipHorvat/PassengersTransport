package com.josip.passenegertransport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ApplicationController {

    @GetMapping({"", "/", "/index"})
    public String goHome(){
        log.debug("Getting main page");
        return "izbornik";
    }
}

