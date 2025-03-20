package com.siemens.customerapi.repositories;

import com.siemens.customerapi.entities.Customer;
import com.siemens.customerapi.entities.Customer_Tenant1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository_Tenant1 extends JpaRepository<Customer_Tenant1,Long> {




}
