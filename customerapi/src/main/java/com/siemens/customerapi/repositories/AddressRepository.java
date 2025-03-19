package com.siemens.customerapi.repositories;

import com.siemens.customerapi.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
