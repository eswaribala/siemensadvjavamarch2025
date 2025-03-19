package com.siemens.customerapi.dtos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FullNameRequest {
    private String firstName;
    private String lastName;
    private String middleName;

}
