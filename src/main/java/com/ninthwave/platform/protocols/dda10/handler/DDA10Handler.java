package com.ninthwave.platform.protocols.dda10.handler;

import com.ninthwave.platform.protocols.dda10.mapper.DDA10EELRequestMapper;
import com.ninthwave.platform.protocols.dda10.mapper.DDA10EELResponseMapper;
import com.ninthwave.platform.protocols.dda10.model.DDA10AccountListRequest;
import com.ninthwave.platform.eel.handler.EELHandler;
import com.ninthwave.platform.exceptions.BadGatewayException;
import com.ninthwave.platform.protocols.model.Response;
import com.ninthwave.platform.runner.Runner;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Handler for dealing with our DDA1.0 endpoints
 */
@RestController
@RequestMapping("dda10")
@RequiredArgsConstructor
public class DDA10Handler {

    private final EELHandler eelHandler;
    private final DDA10EELResponseMapper responseMapper;
    private final DDA10EELRequestMapper requestMapper;
    private final Runner runner;

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