package com.siemens.customerapi.services;

import com.siemens.customerapi.entities.Customer;

import java.util.List;

public interface ICustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomerEmail(long customerId, String email);
    Customer updateCustomerContactNo(long customerId, String contactNo);
    boolean deleteCustomer(long customerId);
    Customer getCustomerById(long customerId);
    List<Customer> getCustomerByContactNo(String contactNo);
    List<Customer> getAllCustomers();

}
