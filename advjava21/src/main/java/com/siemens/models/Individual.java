package com.siemens.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Individual extends Customer{

  private Gender gender;
  private LocalDate dateOfBirth;
}
