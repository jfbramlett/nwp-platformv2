package com.ninthwave.platform.protocols.dda10.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ninthwave.platform.protocols.model.Response;
import lombok.*;

import java.util.List;

/**
 * Value object representing a DDA 1.0 account list response
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DDA10AccountListResponse extends Response {
    private List<DDA10AccountResponse> accounts;
}
