package com.ninthwave.platform.eel.handler;

import com.ninthwave.platform.eel.model.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Internal handler that performs our more generic operations against a given FI. This deals with data at a EEL level
 * Integration with an external FI is handled by REST requests to an external service using convention based URL's.
 */
@Component
public class EELHandler {
    public EELHandler() {
    }

    /**
     * Gets a list of accounts for a given user
     * @param eRequest The incoming request
     * @return EELResponse The account list response in EEL format
     */
    public EELResponse getAccountList(final EELRequest eRequest) {
        AccountListRequest request = (AccountListRequest) eRequest;

        List<AccountResponse> accounts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            accounts.add(new AccountResponse(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                    new BigDecimal("55.5"), UUID.randomUUID().toString()));
        }

        return new AccountListResponse(accounts);
    }
}
