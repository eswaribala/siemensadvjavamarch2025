package com.siemens.views;

import com.github.javafaker.Faker;
import com.siemens.models.Address;
import com.siemens.models.FullName;
import com.siemens.models.Gender;
import com.siemens.models.Individual;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class IndividualComparatorDemo {

    public static void main(String[] args) {

        for(Individual individual:generateIndividuals())
            System.out.println(individual);


    }

    public static List<Individual> generateIndividuals(){

        List<Individual> individuals = new ArrayList<>();
        Individual individual=null;
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            individual = Individual.builder()
                    .accountNo(faker.number().numberBetween(10000,1000000))
                    .fullName(new FullName(faker.name().firstName(),"",faker.name().lastName()))
                    .addresses(generateAddresses())
                    .contactNo(faker.phoneNumber().cellPhone())
                    .email(faker.internet().emailAddress())
                    .password(faker.internet().password())
                    .gender(getRandomGender())
                    .dateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                    .build();
       individuals.add(individual);
        }
        return individuals;

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

    public static Gender getRandomGender(){
        Gender[] values=Gender.values();
        return values[(int)(Math.random()*values.length)];
    }

}
