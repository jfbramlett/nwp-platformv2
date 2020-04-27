package com.ninthwave.platform.eel.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * EEL response holding the details of an account
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountResponse extends EELResponse {
    private String accountId;
    private String accountNumber;
    private String accountName;
    private BigDecimal balance;
    private String accountType;
}
