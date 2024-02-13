package com.example.raiffaisen.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// StartupController.java
@RestController
@RequestMapping("/startup")
public class StartupController {
    @GetMapping
    public String startupHome() {
        return "Startup-Page";
    }
}
