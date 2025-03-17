package com.siemens.views;

import com.siemens.models.Individual;

public class StreamDemo {
    public static void main(String[] args) {

        //filter the individual who born before 2000

        IndividualComparatorDemo.generateIndividuals().stream()
                .filter(i->i.getDateOfBirth().getYear()<2000)
                .map(Individual::getFullName)
                .forEach(System.out::println);

       //count

       long count= IndividualComparatorDemo.generateIndividuals().stream()
                .filter(i->i.getDateOfBirth().getYear()<2000)
                .count();
       System.out.println("Number of people born before 2000=>"+count);

      // sorting

        IndividualComparatorDemo.generateIndividuals().stream()
                .filter(i->i.getDateOfBirth().getYear()<2000)
                .sorted((obj1,obj2)->{return obj1.getDateOfBirth().compareTo(obj2.getDateOfBirth());})

                .forEach(System.out::println);


    }
}
