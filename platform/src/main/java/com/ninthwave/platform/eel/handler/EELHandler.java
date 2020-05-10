package com.ninthwave.platform.eel.handler;

import com.ninthwave.platform.eel.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(EELHandler.class);

    private RestTemplate restTemplate = new RestTemplate();

    private final String host;

    public EELHandler() {
        String envHost = System.getenv("SAMPLE-FI-HOST");
        if (envHost == null) {
            logger.info("No external host defined, using localhost");
            envHost = "localhost";
        }
        this.host = envHost;
    }

    /**
     * Gets a list of accounts for a given user
     * @param eRequest The incoming request
     * @return EELResponse The account list response in EEL format
     */
    public EELResponse getAccountList(final EELRequest eRequest) {
        String url = "http://" + host + ":8083/samplefi/accountlist";
        logger.info("Calling external service for account list: " + url);
        AccountListResponse response = restTemplate.getForObject(url, AccountListResponse.class);

        return response;
    }
}
