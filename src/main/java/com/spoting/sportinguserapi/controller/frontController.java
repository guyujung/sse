package com.spoting.sportinguserapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class frontController {
    @GetMapping("/app")
    public String app1() {
        return "index";
    }
}
