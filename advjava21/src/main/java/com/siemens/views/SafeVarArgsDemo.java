package com.siemens.views;

import com.siemens.models.Person;

import java.util.Arrays;

public class SafeVarArgsDemo {
    public static void main(String[] args) {

       showSkillSets("C#");
       showSkillSets("Java","C#");
       showSkillSets("C++","Java","C#");
    }

    @SafeVarargs
    private static <T> void showSkillSets(T... skills){
         Arrays.stream(skills).toList().forEach(System.out::println);
    }
}
