package com.example.raiffaisen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// InvestorController.java
@Controller
@RequestMapping("/investor")
public class InvestorController {
    @GetMapping
    public String investorHome() {
        return "investor-home";
    }
}
