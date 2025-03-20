package com.siemens.customerapi.entities;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name="Customer_tenant1")
@Inheritance(strategy=InheritanceType.JOINED)
public class Customer_Tenant1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
    @Schema(hidden = true)
    protected long customerId;
    @Embedded
    protected FullName fullName;
    @Column(name="Contact_No")
    protected String contactNo;
    @Column(name="Email", unique=true, nullable=false, length=255)
    protected String email;
    @Column(name="Password", nullable=false, length=10)
    protected String password;

}
