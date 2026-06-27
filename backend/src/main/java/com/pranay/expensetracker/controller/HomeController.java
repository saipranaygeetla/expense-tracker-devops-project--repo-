package com.pranay.expensetracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Expense Tracker Backend Running";
    }

    @GetMapping("/health")
    public String health() {
        return "Application Healthy";
    }

    @GetMapping("/version")
    public String version() {
        return "Version 1.0";
    }
}