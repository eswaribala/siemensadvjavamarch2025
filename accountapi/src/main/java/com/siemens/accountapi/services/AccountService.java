package com.siemens.accountapi.services;

import com.siemens.accountapi.models.Account;
import com.siemens.accountapi.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account addAccount(Account account) {
        return this.accountRepository.save(account);
    }
}
