package com.siemens.customerapi.repositories;

import com.siemens.customerapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("FROM Customer c WHERE c.contactNo = :contactNo")
    List<Customer> findByContactNo(@Param("contactNo") String contactNo);


}
