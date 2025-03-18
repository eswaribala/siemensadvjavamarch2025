package com.siemens.views;

import com.siemens.models.Individual;

import java.util.List;

public class ImmutableCollectionDemo {
    public static void main(String[] args) {

        //immutable collection
       List<Individual> individualList= List.copyOf(IndividualComparatorDemo.generateIndividuals());
       individualList.add(new Individual());
    }
}
