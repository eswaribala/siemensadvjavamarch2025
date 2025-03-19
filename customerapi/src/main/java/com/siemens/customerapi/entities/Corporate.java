package com.siemens.customerapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="Corporate")
public class Corporate extends Customer{
    @Enumerated(EnumType.STRING)
    @Column(name="Company_Type")
    private CompanyType companyType;

}
