package com.siemens.views;

import com.github.javafaker.Faker;
import com.siemens.dtos.Transaction;

import java.time.ZoneId;

public class RecordDemo {
    public static void main(String[] args) {

        Faker faker = new Faker();
        //immutable object
        Transaction transaction=new Transaction(faker.number().numberBetween(500,5000000),
                faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                faker.name().firstName(),
                faker.name().firstName());
        System.out.println(transaction);

    }
}
