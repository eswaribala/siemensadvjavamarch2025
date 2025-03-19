package com.siemens.customerapi.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="Customer")
@Inheritance(strategy=InheritanceType.JOINED)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
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
