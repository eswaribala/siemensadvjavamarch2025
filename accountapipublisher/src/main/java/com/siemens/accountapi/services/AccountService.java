package com.siemens.accountapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.javafaker.Faker;
import com.siemens.accountapi.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;
    @Value("${topicname}")
    private String topicName;


    @Override
    public CompletableFuture<SendResult<Object, Object>> publishAccountDetails(Account account) throws JsonProcessingException {
        Faker faker=new Faker();
        account.setAccountNo(faker.number().numberBetween(100000L,99999999L));
        account.setOpeningDate(faker.date().birthday().toString());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(account);
        //publishing the data
        return  kafkaTemplate.send(topicName,json);

    }
}
