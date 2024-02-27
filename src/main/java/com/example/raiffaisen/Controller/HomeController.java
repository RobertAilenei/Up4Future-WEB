package com.example.raiffaisen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// HomeController.java

@Controller
@RequestMapping("/Home")
public class HomeController {
    @GetMapping
    public String home() {
        return "Home";
    }
}
