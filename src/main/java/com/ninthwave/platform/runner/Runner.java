package com.ninthwave.platform.runner;

import com.ninthwave.platform.eel.model.EELRequest;
import com.ninthwave.platform.eel.model.EELResponse;
import com.ninthwave.platform.exceptions.BaseException;
import com.ninthwave.platform.model.ErrorResponse;
import com.ninthwave.platform.model.Request;
import com.ninthwave.platform.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Runner orchestrates any given incoming call since they all essentially do the same thing, they map the incoming
 * request to an EEL request, executes the handler for that request, and then translates the results from EEL
 * to our outgoing protocol.
 *
 * This also handles our exception handling and error reporting.
 */
@Component
public class Runner {
    public Runner() {

    }

    public ResponseEntity<Response> run(final Request request,
                                        Function<Request, EELRequest> requestMapper,
                                        Function<EELRequest, EELResponse> executor,
                                        Function<EELResponse, Response> responseMapper) {
        try {
            return new ResponseEntity<>(responseMapper.apply(executor.apply(requestMapper.apply(request))),
                    HttpStatus.OK);
        } catch (BaseException be) {
            return new ResponseEntity<>(new ErrorResponse(be.getMessage(), be.getCode(), be.getHttpCode()),
                    HttpStatus.valueOf(be.getHttpCode()));
        }
    }
}
