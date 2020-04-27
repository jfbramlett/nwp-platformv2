package com.ninthwave.platform.dda10.model;

import com.ninthwave.platform.model.Request;
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
