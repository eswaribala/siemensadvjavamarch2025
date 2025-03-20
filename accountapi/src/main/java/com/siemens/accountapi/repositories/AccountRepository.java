package com.siemens.accountapi.repositories;

import com.siemens.accountapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
