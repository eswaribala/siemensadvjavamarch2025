package com.siemens.views;

import com.github.javafaker.Faker;
import com.siemens.dtos.IndividualDTO;
import com.siemens.models.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
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

     //pick first 10 records
        IndividualComparatorDemo.generateIndividuals()
                .stream().limit(10).forEach(System.out::println);
     //skip first 10 records

        IndividualComparatorDemo.generateIndividuals()
                .stream().skip(10).forEach(System.out::println);

     //flatten the list

     List<Person> personList=  getPersonList();
     List<Hobby> hobbyList=personList.stream().map(Person::getHobbies)
             .flatMap(List::stream)
             .distinct()
             .toList();

    hobbyList.forEach(System.out::println);

    //aggregation

      Optional<BigDecimal> maxValue=  generateSavingsAccounts().stream().map(Account::getRunningTotal)
              .max(BigDecimal::compareTo);

        maxValue.ifPresent(System.out::println);

       BigDecimal openingTotalSum= generateSavingsAccounts().stream().map(Account::getRunningTotal)
                .reduce(BigDecimal.valueOf(0.0),BigDecimal::add);
       System.out.println("Sum="+openingTotalSum);

       //custom collector
      AccountAggregator accountAggregator=  generateSavingsAccounts().stream()
              .collect(new AccountCustomCollector());

     System.out.println(accountAggregator.getTotalCost());


    }

    public static  List<Person> getPersonList(){
        List<Person> personList= new ArrayList<>();
        Person person=null;
        Faker faker = new Faker();
        for(int i=0; i<10; i++){

            person=new Person();
            person.setName(faker.name().firstName());
            person.setHobbies(getHobbies());
            personList.add(person);
        }
        return personList;
    }

    public static  List<Hobby> getHobbies(){
        List<Hobby> hobbiesList= new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i<new Random().nextInt(2,7); i++){
            hobbiesList.add(getRandomHobby());

        }

        return hobbiesList;
    }
    public static Hobby getRandomHobby(){
        Hobby[] values=Hobby.values();
        return values[(int)(Math.random()*values.length)];
    }


    public static List<SavingsAccount> generateSavingsAccounts(){

        List<SavingsAccount> savingsAccountList= new ArrayList<>();
        Faker faker = new Faker();
        SavingsAccount savingsAccount=null;
        for(int i=0; i<100; i++){
            savingsAccount=new SavingsAccount();
            savingsAccount.setRunningTotal(BigDecimal.valueOf(faker.number().numberBetween(5000,1000000)));
            savingsAccount.setOpeningDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            savingsAccount.setInterestRate(faker.number().numberBetween(1,100));

            savingsAccountList.add(savingsAccount);
        }
        return savingsAccountList;
    }

}
