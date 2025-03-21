package com.siemens.accountapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)

public class Account {

    @Schema(hidden = true)
    protected long accountNo;

    protected long runningTotal;
    @Schema(hidden = true)
    protected String openingDate;
}
