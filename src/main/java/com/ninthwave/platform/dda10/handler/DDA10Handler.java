package com.ninthwave.platform.dda10.handler;

import java.util.UUID;

import com.ninthwave.platform.dda10.mapper.DDA10EELRequestMapper;
import com.ninthwave.platform.dda10.mapper.DDA10EELResponseMapper;
import com.ninthwave.platform.dda10.model.DDA10AccountListRequest;
import com.ninthwave.platform.dda10.model.Greeting;
import com.ninthwave.platform.eel.handler.EELHandler;
import com.ninthwave.platform.exceptions.BadGatewayException;
import com.ninthwave.platform.model.Response;
import com.ninthwave.platform.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handler for dealing with our DDA1.0 endpoints
 */
@RestController
public class DDA10Handler {

    @Autowired
    private EELHandler eelHandler;
    @Autowired
    private DDA10EELResponseMapper responseMapper;
    @Autowired
    private DDA10EELRequestMapper requestMapper;
    @Autowired
    private Runner runner;

    /**
     * Gets the list of accounts for the active user
     * @return ResponseEntity A Spring response entity holding the list of accounts
     */
    @GetMapping("/accountlist")
    public ResponseEntity<Response> accountlist() {
        return runner.run(new DDA10AccountListRequest("1", "1234"),
                (r) -> requestMapper.dda10AccountListRequestToEEL(r),
                (e) -> eelHandler.getAccountList(e),
                (r) -> responseMapper.fromAccountListResponse(r));
    }

    /**
     * Gets the account details for the given account (provided as a path variable)
     * @param accountId The account id provided as a path variable
     * @return ResponseEntity The account details
     */
    @GetMapping("/account/{accountId}")
    public ResponseEntity<Response> account(@PathVariable String accountId) {
        return runner.run(new DDA10AccountListRequest("1", "1234"),
                (r) -> {
                    throw new BadGatewayException("failed to obtain account");
                },
                (e) -> eelHandler.getAccountList(e),
                (r) -> responseMapper.fromAccountListResponse(r));
    }

}