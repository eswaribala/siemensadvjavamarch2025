package com.siemens.accountapi.services;

import com.siemens.accountapi.models.Account;

import java.util.List;

public interface IAccountService {
    Account addAccount(Account account);
    List<Account> getAccounts();
}
