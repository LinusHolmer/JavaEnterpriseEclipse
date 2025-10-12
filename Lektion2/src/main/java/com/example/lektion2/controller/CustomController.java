package com.example.lektion2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomController {

    @GetMapping("/home")
    public String home() {
        return "home.html";
    }
}
