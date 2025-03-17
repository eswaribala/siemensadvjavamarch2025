package com.siemens.views;

import com.siemens.dtos.IndividualDTO;
import com.siemens.models.Individual;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

      // sorting and creating the list

      List<IndividualDTO> individualDTOList=  IndividualComparatorDemo.generateIndividuals().stream()
                .filter(i->i.getDateOfBirth().getYear()<2000)
                .sorted((obj1,obj2)->{return obj1.getDateOfBirth().compareTo(obj2.getDateOfBirth());})
                .map(individual -> new IndividualDTO(individual.getFullName().getFirstName(),
                        individual.getDateOfBirth()))
                .toList();

      individualDTOList.forEach(System.out::println);

      //sort and create map
      Map<String, LocalDate> map=  IndividualComparatorDemo.generateIndividuals().stream()
                .filter(i->i.getDateOfBirth().getYear()<2000)
                .sorted((obj1,obj2)->{return obj1.getDateOfBirth().compareTo(obj2.getDateOfBirth());})
                .collect(Collectors.toMap(i->i.getFullName().getFirstName(),
                        Individual::getDateOfBirth));

      map.entrySet().stream().forEach(entrySet->
              System.out.println(entrySet.getKey()+" "+entrySet.getValue()));

    }
}
