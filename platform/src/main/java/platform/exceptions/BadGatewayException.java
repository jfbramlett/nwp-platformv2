package com.ninthwave.platform.exceptions;

/**
 * Exception for a BadGateway
 */
public class BadGatewayException extends BaseException {
    public BadGatewayException(final String msg) {
        super(msg, 10, 401);
    }
    public BadGatewayException(final String msg, final Throwable cause) {
        super(msg, 10, 401, cause);

    }

}
