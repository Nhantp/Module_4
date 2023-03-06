package com.codegym.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(){
        return "index";
    }
}
