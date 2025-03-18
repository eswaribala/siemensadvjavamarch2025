package com.siemens.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String  street;
    private String city;
    private String suite;
    private String zipcode;
    private Geo geo;


}
