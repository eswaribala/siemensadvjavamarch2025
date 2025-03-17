package com.siemens.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Corporate extends Customer {

    private CompanyType companyType;
}
