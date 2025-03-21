package com.siemens.resillience4jdemo.controllers;

import com.siemens.resillience4jdemo.services.CBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CBController {
    @Autowired
    private CBService cbService;

    @GetMapping("/")
    public String getAccountDetails() {
        return cbService.CBAccountService();

    }
}
