package com.example.raiffaisen.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

// HomeController.java
@RestController
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bine ai venit pe platforma noastră!");
        return Objects.requireNonNull(model.getAttribute("message")).toString(); // Numele view-ului (de exemplu, home.html în src/main/resources/templates)
    }
}

