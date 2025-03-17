package com.siemens.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Corporate extends Customer {

    private CompanyType companyType;
}
