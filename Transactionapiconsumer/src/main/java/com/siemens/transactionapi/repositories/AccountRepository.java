package com.siemens.transactionapi.repositories;

import com.siemens.transactionapi.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
