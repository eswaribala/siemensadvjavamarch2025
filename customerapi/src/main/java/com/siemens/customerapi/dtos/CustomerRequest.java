package com.siemens.customerapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @Schema(hidden = true)
    protected long customerId;

    protected FullNameRequest fullName;

    protected String contactNo;
    @NotNull(message = "email cannot be null")
    @Email(message = "Not according to pattern")
    protected String email;
    @NotNull(message = "password cannot be null")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}", message = "Password format Not Matching")
    @Schema(example = "Test@123", defaultValue = "")
    protected String password;
}
