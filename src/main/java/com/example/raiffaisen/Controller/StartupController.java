package com.example.raiffaisen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// StartupController.java
@Controller
@RequestMapping("/startup")
public class StartupController {
    @GetMapping
    public String startupHome() {
        return "startup-home";
    }
}
