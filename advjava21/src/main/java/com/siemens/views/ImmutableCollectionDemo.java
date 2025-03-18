package com.siemens.views;

import com.siemens.models.Individual;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImmutableCollectionDemo {
    public static void main(String[] args) {

        //immutable collection
        //java 10
       List<Individual> individualList= List.copyOf(IndividualComparatorDemo.generateIndividuals());
      // individualList.add(new Individual());

       // map
     Map<Long,String> customerMap=  IndividualComparatorDemo.generateIndividuals().stream()
                .collect(Collectors.toMap(x->x.getAccountNo(),x->x.getContactNo()));
     //immutable
      Map<Long,String> customerImmutableMap=  Map.copyOf(customerMap);
      //customerImmutableMap.put(243432543L,"qerwer");


    }
}
