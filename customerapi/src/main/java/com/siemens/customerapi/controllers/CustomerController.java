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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/v1.0")
    public List<Customer> fetchAllCustomers(){
        return this.customerService.getAllCustomers();
    }

    @GetMapping("/v1.0/{customerId}")
    public Customer fetchCustomerById(@PathVariable("customerId") long customerId){
        return this.customerService.getCustomerById(customerId);

    }
    @GetMapping("/v1.0/byContactNo/{contactNo}")
    public List<Customer> fetchCustomerByContactNo(@PathVariable("contactNo") String contactNo){

        return this.customerService.getCustomerByContactNo(contactNo);

    }

    @PutMapping("/v1.0")
    public ResponseEntity<GenericResponse> updateCustomerEmail(@RequestParam("customerId") long customerId, @RequestParam("email") String email){

        Customer customer = this.customerService.updateCustomerEmail(customerId, email);
        if(customer!=null){
            return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<>(customer));
         }else
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse<>("Customer Not Updated"));
    }

    @PutMapping("/v1.0/updateContact")
    public ResponseEntity<GenericResponse> updateCustomerContactNo(@RequestParam("customerId") long customerId, @RequestParam("contactNo") String contactNo){

        Customer customer = this.customerService.updateCustomerContactNo(customerId, contactNo);
        if(customer!=null){
            return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<>(customer));
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse<>("Customer Not Updated"));
    }

    @DeleteMapping("/v1.0/{customerId}")
    public ResponseEntity<GenericResponse> deleteCustomerById(@PathVariable("customerId") long customerId){
         if(this.customerService.deleteCustomer(customerId)){
             return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<>("Customer Deleted"));
         }else {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse<>("Customer Not Deleted"));
         }
    }
}
