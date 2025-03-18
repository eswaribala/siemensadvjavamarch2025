package com.siemens.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public sealed class Individual extends Customer permits LargeTaxPayer{

  private Gender gender;
  private LocalDate dateOfBirth;
}
