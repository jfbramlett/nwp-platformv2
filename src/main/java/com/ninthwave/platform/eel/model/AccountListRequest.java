package com.ninthwave.platform.eel.model;

import lombok.*;

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
