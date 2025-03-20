package com.siemens.accountapi.controllers;

import com.siemens.accountapi.models.Account;
import com.siemens.accountapi.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @PostMapping("/v1.0")
    public ResponseEntity<?> addAccount(@RequestBody Account account) {

       Account account1= this.accountService.addAccount(account);
       if(account1!=null){
           return ResponseEntity.status(HttpStatus.CREATED).body(account1);
       }else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account not added");
       }
    }
}
