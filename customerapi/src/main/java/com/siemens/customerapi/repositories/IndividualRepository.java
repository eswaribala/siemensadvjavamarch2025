package com.siemens.customerapi.repositories;

import com.siemens.customerapi.entities.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual, Long> {
}
