package com.siemens.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.SplittableRandom;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private long addressNo;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
