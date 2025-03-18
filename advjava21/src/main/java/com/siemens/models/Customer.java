package com.siemens.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
public sealed class Customer permits Individual,Corporate {
    protected long accountNo;
    protected FullName fullName;
    protected List<Address> addresses;
    protected String contactNo;
    protected String email;
    protected String password;

}
