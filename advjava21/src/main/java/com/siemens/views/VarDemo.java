package com.siemens.views;

import com.siemens.models.Individual;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.function.Function;

public class VarDemo {
    public static void main(String[] args) {

        var name="Parameswari";
        //get the data type of the variable
        System.out.println(name.getClass().getSimpleName());
        var salary= 46796.78;
        Object object= salary;
        System.out.println(object.getClass().getSimpleName());
        Function<Individual, LocalDate> function=(var obj)->{
            return obj.getDateOfBirth();
        };
       System.out.println(function.apply(IndividualComparatorDemo.generateIndividuals().get(0)));

        IndividualComparatorDemo.generateIndividuals().stream()
                .map((@NonNull var i)->i.getFullName().getFirstName().toUpperCase())
                .forEach(System.out::println);

    }
}
