package com.siemens.views;

import com.github.javafaker.Faker;
import com.siemens.models.*;

import java.util.ArrayList;
import java.util.List;

public class PatternMatcherDemo {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Corporate corporate=Corporate.builder()
                .accountNo(faker.number().numberBetween(10000,1000000))
                .fullName(new FullName(faker.name().firstName(),"",faker.name().lastName()))
                .addresses(generateAddresses())
                .contactNo(faker.phoneNumber().cellPhone())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .companyType(getRandomCompanyType())
                .build();

        //instance check
        //pattern matcher
        if(corporate instanceof Customer customer){
            System.out.println(customer.getAccountNo());
        }



    }
    public static List<Address> generateAddresses(){

        List<Address> addresses = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 2; i++) {
            addresses.add(new Address(faker.number().numberBetween(1000,1000000),
                    faker.address().streetAddressNumber(),
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().state(),
                    faker.address().zipCode(),
                    faker.address().country()

            ));
        }

        return addresses;

    }
    public static CompanyType getRandomCompanyType(){
        CompanyType[] values=CompanyType.values();
        return values[(int)(Math.random()*values.length)];
    }
}
