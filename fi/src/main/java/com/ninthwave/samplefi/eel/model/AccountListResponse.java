package com.ninthwave.samplefi.eel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * EEL representation of the response holding a list of accounts
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountListResponse extends EELResponse {
    private List<AccountResponse> accounts;
}
