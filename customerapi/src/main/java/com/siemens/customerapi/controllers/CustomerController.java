package com.siemens.customerapi.controllers;

import com.siemens.customerapi.dtos.CustomerRequest;
import com.siemens.customerapi.dtos.GenericResponse;
import com.siemens.customerapi.entities.Customer;
import com.siemens.customerapi.entities.FullName;
import com.siemens.customerapi.services.CustomerService;
import com.siemens.customerapi.services.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;


    @PostMapping("/v1.0")
    public ResponseEntity<GenericResponse> addCustomer(@Valid @RequestBody CustomerRequest customerRequest){

        Customer customer = Customer.builder()
                .customerId(customerRequest.getCustomerId())
                .fullName(FullName.builder()
                        .firstName(customerRequest.getFullName().getFirstName())
                        .lastName(customerRequest.getFullName().getLastName())
                        .middleName(customerRequest.getFullName().getMiddleName())
                        .build())
                .contactNo(customerRequest.getContactNo())
                .email(customerRequest.getEmail())
                .password(customerRequest.getPassword())
                .build();
        Customer customerObject=customerService.addCustomer(customer);
        if(customerObject!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponse<>(customerObject));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse<>("Customer Not Added"));
        }


    }

}
