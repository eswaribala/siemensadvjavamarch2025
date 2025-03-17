package com.siemens.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    protected long accountNo;
    protected FullName fullName;
    protected List<Address> addresses;
    protected long contactNo;
    protected String email;
    protected String password;

}
