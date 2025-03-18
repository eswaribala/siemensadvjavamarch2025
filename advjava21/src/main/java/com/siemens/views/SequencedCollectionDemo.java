package com.siemens.views;

import com.siemens.models.Individual;

import java.util.SequencedCollection;

public class SequencedCollectionDemo {
    public static void main(String[] args) {
        SequencedCollection<Individual> sequencedCollection=IndividualComparatorDemo.generateIndividuals();
        System.out.println(sequencedCollection.getFirst());
        System.out.println(sequencedCollection.getLast());
        System.out.println(sequencedCollection.size());
        SequencedCollection<Individual> reversedSequencedCollection = sequencedCollection.reversed();
        System.out.println(reversedSequencedCollection.getFirst());
        System.out.println(reversedSequencedCollection.getLast());

    }
}
