package com.ninthwave.platform.dda10.mapper;

import com.ninthwave.platform.dda10.model.DDA10AccountListRequest;
import com.ninthwave.platform.eel.model.AccountListRequest;
import com.ninthwave.platform.eel.model.EELRequest;
import com.ninthwave.platform.model.Request;
import org.springframework.stereotype.Component;

/**
 * Holds our mappings from our incoming requests to our internal EEL representations for the DDA1.0 spec
 */
@Component
public class DDA10EELRequestMapper {
    public DDA10EELRequestMapper() {

    }

    /**
     * Maps a DDA 1.0 account list request to an EEL request
     * @param request The incoming account list request
     * @return EELRequest the EEL request representation of an DDA 1.0 account list request
     */
    public EELRequest dda10AccountListRequestToEEL(final Request request) {
        DDA10AccountListRequest ddaAccountListReq = (DDA10AccountListRequest) request;
        return new AccountListRequest(ddaAccountListReq.getCustomerId(), ddaAccountListReq.getFid());
    }
}