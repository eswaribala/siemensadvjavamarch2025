package com.siemens.transactionapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.siemens.transactionapi.models.Account;
import org.springframework.kafka.support.SendResult;


import java.util.concurrent.CompletableFuture;

public interface IAccountService {

    void consumeAccountDetails(String account) ;
}
