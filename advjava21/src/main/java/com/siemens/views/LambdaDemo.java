package com.siemens.views;

import com.github.javafaker.Faker;
import com.siemens.fadades.DataGenerator;

public class LambdaDemo {
    public static void main(String[] args) {

        DataGenerator dataGenerator=(min,max)->{
            return (new Faker().number().numberBetween(min,max));
        };
       System.out.println("Generated OTP="+dataGenerator.otpGenerator(1000,9999));
    }
}
