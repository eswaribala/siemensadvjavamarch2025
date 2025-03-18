package com.siemens.views;

import com.github.javafaker.Faker;
import com.siemens.models.*;

import java.math.BigDecimal;
import java.time.ZoneId;

public class SwitchExpressionDemo {
    public static void main(String[] args) {
       Faker faker = new Faker();
        SavingsAccount savingsAccount = SavingsAccount.builder()
                .runningTotal(BigDecimal.valueOf(faker.number().numberBetween(5000,100000)))
                .openingDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .interestRate(faker.number().numberBetween(0,100))
                .build();
        CurrentAccount currentAccount = CurrentAccount.builder()
                .runningTotal(BigDecimal.valueOf(faker.number().numberBetween(5000,100000)))
                .openingDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .overDraftLimit(faker.number().numberBetween(1000000,10000000))
                .build();
        System.out.println(getAccountType(savingsAccount));
        System.out.println(getAccountType(currentAccount));

    }

    public static String getAccountType(Account account){

        return switch (account){
             case SavingsAccount savingsAccount-> "Savings Account";
             case CurrentAccount currentAccount-> "Current Account";
             default -> null;
         };
    }
}
