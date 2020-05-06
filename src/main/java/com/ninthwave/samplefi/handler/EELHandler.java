package com.ninthwave.samplefi.handler;

import com.ninthwave.samplefi.eel.model.AccountListResponse;
import com.ninthwave.samplefi.eel.model.AccountResponse;
import com.ninthwave.samplefi.eel.model.EELResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Handler for dealing with our DDA1.0 endpoints
 */
@RestController
@RequestMapping("samplefi")
@RequiredArgsConstructor
public class EELHandler {

    /**
     * Gets the list of accounts for the active user
     * @return ResponseEntity A Spring response entity holding the list of accounts
     */
    @GetMapping("/accountlist")
    public ResponseEntity<EELResponse> accountlist() {
        List<AccountResponse> accounts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            accounts.add(new AccountResponse(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                    new BigDecimal("55.5"), UUID.randomUUID().toString()));
        }

        AccountListResponse accountListResponse = new AccountListResponse(accounts);

        return new ResponseEntity<>(accountListResponse, HttpStatus.OK);
    }

    /**
     * Gets the account details for the given account (provided as a path variable)
     * @param accountId The account id provided as a path variable
     * @return ResponseEntity The account details
     */
    @GetMapping("/account/{accountId}")
    public ResponseEntity<EELResponse> account(@PathVariable String accountId) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(accountId);
        accountResponse.setAccountName("My checking account");
        accountResponse.setAccountType("CHECK");
        accountResponse.setAccountNumber("8675309");
        accountResponse.setBalance(new BigDecimal("1099.50"));

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

}