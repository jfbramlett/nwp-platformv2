package com.ninthwave.platform.dda10.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ninthwave.platform.model.Response;
import lombok.*;

import java.math.BigDecimal;

/**
 * Value object representing a DDA 1.0 account response
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DDA10AccountResponse extends Response {
    private String accountId;
    private String accountNumber;
    private String accountName;
    private BigDecimal balance;
    private String accountType;
}
