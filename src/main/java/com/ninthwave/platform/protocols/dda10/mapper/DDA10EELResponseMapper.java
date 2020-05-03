package com.ninthwave.platform.protocols.dda10.mapper;

import com.ninthwave.platform.protocols.dda10.model.DDA10AccountListResponse;
import com.ninthwave.platform.protocols.dda10.model.DDA10AccountResponse;
import com.ninthwave.platform.eel.model.AccountListResponse;
import com.ninthwave.platform.eel.model.AccountResponse;
import com.ninthwave.platform.eel.model.EELResponse;
import com.ninthwave.platform.protocols.model.Response;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Maps our EEL response in to spec (i.e. DDA 1.0) specific responses
 */
@Component
public class DDA10EELResponseMapper {
    public DDA10EELResponseMapper() {

    }

    /**
     * Maps an EEL AccountListResponse object to our outgoing DDA 1.0 account list response format
     * @param response The EEL response data to convert
     * @return Response The DDA 1.0 specific response representation
     */
    public Response fromAccountListResponse(final EELResponse response) {
        AccountListResponse eelResponse = (AccountListResponse)response;
        List<DDA10AccountResponse> accounts = new ArrayList<>();
        for (AccountResponse ar : eelResponse.getAccounts()) {
            accounts.add(new DDA10AccountResponse(ar.getAccountId(), ar.getAccountNumber(), ar.getAccountName(), ar.getBalance(), ar.getAccountType()));
        }
        return new DDA10AccountListResponse(accounts);
    }
}
