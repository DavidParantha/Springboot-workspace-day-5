package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {

    @GetMapping("/bank/getData")
    public String getBankData() {
        return "Returning data from ICICI-BANK-SERVICE";
    }
}
