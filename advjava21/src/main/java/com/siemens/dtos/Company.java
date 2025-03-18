package com.siemens.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Company {
  private String name;
  private String catchPhrase;
  private String bs;
}
