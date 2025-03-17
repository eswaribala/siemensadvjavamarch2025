package com.siemens.views;

import com.siemens.dtos.IndividualDTO;
import com.siemens.models.Gender;
import com.siemens.models.Individual;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
      /*Map<String, LocalDate> map=  IndividualComparatorDemo.generateIndividuals().stream()
                .filter(i->i.getDateOfBirth().getYear()<1990)
                .sorted((obj1,obj2)->{return obj1.getDateOfBirth().compareTo(obj2.getDateOfBirth());})
                .collect(Collectors.toMap(i->i.getFullName().getFirstName(),
                        Individual::getDateOfBirth));

      map.entrySet().stream().forEach(entrySet->
              System.out.println(entrySet.getKey()+" "+entrySet.getValue()));
*/
      //count how many male,female and other individuals

    Map<Gender,Long>  mappedCount=  IndividualComparatorDemo.generateIndividuals().stream()
                .collect(Collectors.groupingBy(Individual::getGender,Collectors.counting()));
    mappedCount.entrySet().stream().forEach(entrySet->System.out.println(entrySet.getKey()+" "+entrySet.getValue()));

//all match

       System.out.println(IndividualComparatorDemo.generateIndividuals()
               .stream().allMatch(i->i.getFullName().getFirstName().startsWith("A")));
        System.out.println(IndividualComparatorDemo.generateIndividuals()
                .stream().anyMatch(i->i.getFullName().getFirstName().startsWith("A")));

   //find first
     Optional<Individual> individualOptional=  IndividualComparatorDemo.generateIndividuals()
                .stream().filter(i->i.getDateOfBirth().getYear()==1994).findFirst();

     if(individualOptional.isPresent()){
         System.out.println(individualOptional.get());
     }else {
         System.out.println("No record found");
     }
//find any
        Optional<Individual> individualOptional1=  IndividualComparatorDemo.generateIndividuals()
                .stream().filter(i->i.getDateOfBirth().getYear()==1994).findAny();

        if(individualOptional1.isPresent()){
            System.out.println(individualOptional.get());
        }else {
            System.out.println("No record found");
        }


    //exception

     Individual object=IndividualComparatorDemo.generateIndividuals()
                .stream().filter(i->i.getDateOfBirth().getYear()==1994)
             .findFirst()
             .orElseThrow(()->new RuntimeException("No record found"));
        System.out.println(object);
    }
}
