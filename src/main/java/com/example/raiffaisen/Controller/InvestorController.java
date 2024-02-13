package com.example.raiffaisen.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// InvestorController.java
@RestController
@RequestMapping("/investor")
public class InvestorController {
    @GetMapping
    public String investorHome() {
        return "Investor-Page";
    }
}
