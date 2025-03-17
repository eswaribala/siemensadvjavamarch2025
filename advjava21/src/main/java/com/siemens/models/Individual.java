package com.siemens.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Individual extends Customer{

  private Gender gender;
  private LocalDate dateOfBirth;
}
