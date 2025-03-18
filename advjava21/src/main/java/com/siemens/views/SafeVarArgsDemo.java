package com.siemens.views;

import com.siemens.models.Person;

import java.util.Arrays;

public class SafeVarArgsDemo {
    public static void main(String[] args) {
      SafeVarArgsDemo safeVarArgsDemo = new SafeVarArgsDemo();

        safeVarArgsDemo.showSkillSets("C#");
        safeVarArgsDemo.showSkillSets("Java","C#");
        safeVarArgsDemo.showSkillSets("C++","Java","C#");
    }

    @SafeVarargs
    private <T> void showSkillSets(T... skills){
         Arrays.stream(skills).toList().forEach(System.out::println);
    }
}
