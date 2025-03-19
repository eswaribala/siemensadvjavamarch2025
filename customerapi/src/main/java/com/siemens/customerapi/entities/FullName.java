package com.siemens.customerapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class FullName {
    @Column(name="First_Name",nullable = false,length = 50)
    private String firstName;
    @Column(name="Last_Name",nullable = false,length = 50)
    private String lastName;
    @Column(name="Middle_Name",nullable = true,length = 50)
    private String middleName;

}
