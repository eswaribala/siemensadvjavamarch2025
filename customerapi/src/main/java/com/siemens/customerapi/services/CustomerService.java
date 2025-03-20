package com.siemens.customerapi.services;

import com.siemens.customerapi.dtos.CustomerRequest;
import com.siemens.customerapi.dtos.GenericResponse;
import com.siemens.customerapi.entities.Customer;
import com.siemens.customerapi.entities.Customer_Tenant1;
import com.siemens.customerapi.entities.Customer_Tenant2;
import com.siemens.customerapi.entities.FullName;
import com.siemens.customerapi.exceptions.CustomerNotFoundException;
import com.siemens.customerapi.repositories.CustomerRepository;
import com.siemens.customerapi.repositories.CustomerRepository_Tenant1;
import com.siemens.customerapi.repositories.CustomerRepository_Tenant2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired // Inversion of Control
    private CustomerRepository customerRepository;
    @Autowired // Inversion of Control
    private CustomerRepository_Tenant1 customerRepository_tenant1;
    @Autowired // Inversion of Control
    private CustomerRepository_Tenant2 customerRepository_tenant2;
    @Override
    public GenericResponse addCustomer(CustomerRequest customerRequest, String tenant) {
        //insert
        if(tenant.equals("tenant0")) {
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
            return new GenericResponse(this.customerRepository.save(customer));
        }
        else if (tenant.equals("tenant1")) {
            Customer_Tenant1 customer = Customer_Tenant1.builder()
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
            return  new GenericResponse(this.customerRepository_tenant1.save(customer));
        }else if (tenant.equals("tenant2")) {
            Customer_Tenant2 customer = Customer_Tenant2.builder()
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
            return new GenericResponse(this.customerRepository_tenant2.save(customer));
        }
        return null;
    }

    @Override
    public Customer updateCustomerEmail(long customerId, String email) {
        Customer customer = this.getCustomerById(customerId);
        customer.setEmail(email);
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomerContactNo(long customerId, String contactNo) {
        Customer customer = this.getCustomerById(customerId);
        customer.setContactNo(contactNo);
        return this.customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(long customerId) {
        Customer customer = this.getCustomerById(customerId);
        boolean status = false;
        if(customer != null) {
            this.customerRepository.delete(customer);
           status = true;
        }
        return status;
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return this.customerRepository.findById(customerId).orElseThrow(()->
                new CustomerNotFoundException("Customer not found"));
    }

    //non primary key
    @Override
    public List<Customer> getCustomerByContactNo(String contactNo) {
        return this.customerRepository.findByContactNo(contactNo);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
}
