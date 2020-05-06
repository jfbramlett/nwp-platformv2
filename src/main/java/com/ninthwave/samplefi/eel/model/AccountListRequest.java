package com.ninthwave.samplefi.eel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * EEL representation of a request to get a list of accounts
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountListRequest extends EELRequest {
    String customerId;
    String fid;
}
