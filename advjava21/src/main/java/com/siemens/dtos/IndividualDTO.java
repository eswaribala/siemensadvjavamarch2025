package com.siemens.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualDTO {
    private String firstName;
    private LocalDate dateOfBirth;
}
