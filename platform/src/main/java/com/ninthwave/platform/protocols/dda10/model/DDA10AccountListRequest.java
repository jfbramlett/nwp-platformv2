package com.ninthwave.platform.protocols.dda10.model;

import com.ninthwave.platform.protocols.model.Request;
import lombok.*;

/**
 * Value object representing a DDA 1.0 account list request
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DDA10AccountListRequest extends Request {
    String customerId;
    String fid;
}
