package com.ninthwave.platform.eel.model;

import lombok.*;

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
