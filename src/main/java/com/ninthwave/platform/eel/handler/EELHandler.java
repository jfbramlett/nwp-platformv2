package com.ninthwave.platform.eel.handler;

import com.ninthwave.platform.eel.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate = new RestTemplate();

    public EELHandler() {
    }

    /**
     * Gets a list of accounts for a given user
     * @param eRequest The incoming request
     * @return EELResponse The account list response in EEL format
     */
    public EELResponse getAccountList(final EELRequest eRequest) {
        AccountListResponse response = restTemplate.getForObject("http://localhost:8083/samplefi/accountlist", AccountListResponse.class);

        return response;
    }
}
