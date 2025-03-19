package com.siemens.customerapi.repositories;

import com.siemens.customerapi.entities.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CorporateRepository extends JpaRepository<Corporate, Long> {
}
