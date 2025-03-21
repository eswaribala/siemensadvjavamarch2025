package com.siemens.transactionapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.siemens.transactionapi.models.Account;
import com.siemens.transactionapi.repositories.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@KafkaListener(topics = "accountmarch2025", groupId = "saga-account-group")
@Slf4j
public class AccountService implements IAccountService {
    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;
    @Value("${topicname}")
    private String topicName;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    @KafkaHandler(isDefault = true)

    public void consumeAccountDetails(String account) {
    log.info("Consuming account details from topic: " + account);
    Gson gson = new Gson();
    Account account1= gson.fromJson(account, Account.class);
    //writing the object o mongodb
    this.accountRepository.save(account1);

    }
}
