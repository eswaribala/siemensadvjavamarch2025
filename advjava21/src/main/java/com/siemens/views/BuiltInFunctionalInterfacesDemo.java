package com.siemens.views;

import com.github.javafaker.Faker;
import com.siemens.fadades.TriFunction;
import com.siemens.models.FullName;
import com.siemens.models.Individual;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.siemens.views.IndividualComparatorDemo.getRandomGender;

public class BuiltInFunctionalInterfacesDemo {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Individual individual = Individual.builder()
                .accountNo(faker.number().numberBetween(10000,1000000))
                .fullName(new FullName(faker.name().firstName(),"",faker.name().lastName()))
                .addresses(IndividualComparatorDemo.generateAddresses())
                .contactNo(faker.phoneNumber().cellPhone())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .gender(getRandomGender())
                .dateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .build();
        //Function
       Function<Individual, LocalDate> function = Individual::getDateOfBirth;
       System.out.println("DOB="+function.apply(individual));
       BiFunction<Individual,String,Boolean> biFunction =(obj,str)->obj.getPassword().equals(str);
       System.out.println("Result="+biFunction.apply(individual,individual.getPassword()));

        TriFunction<Individual,Individual,Individual,Boolean> triFunction =(obj1,obj2,obj3)->{
            if(obj1.getPassword().equals(obj2.getPassword())){
                if(obj2.getPassword().equals(obj3.getPassword())){
                    return true;
                }else
                    return false;
            }else
                return false;

        };

        System.out.println(triFunction.apply(IndividualComparatorDemo.generateIndividuals().get(0),
                IndividualComparatorDemo.generateIndividuals().get(1),
                IndividualComparatorDemo.generateIndividuals().get(2)));
    }
}
