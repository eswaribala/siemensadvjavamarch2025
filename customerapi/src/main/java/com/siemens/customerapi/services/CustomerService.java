package com.siemens.customerapi.services;

import com.siemens.customerapi.entities.Customer;
import com.siemens.customerapi.exceptions.CustomerNotFoundException;
import com.siemens.customerapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired // Inversion of Control
    private CustomerRepository customerRepository;


    @Override
    public Customer addCustomer(Customer customer) {
        //insert
        return this.customerRepository.save(customer);
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
        this.customerRepository.delete(customer);
        return this.getCustomerById(customerId) == null;

    }

    @Override
    public Customer getCustomerById(long customerId) {
        return this.customerRepository.findById(customerId).orElseThrow(()->
                new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
}
