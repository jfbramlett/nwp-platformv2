package com.ninthwave.platform.exceptions;

import lombok.Getter;

/**
 * Base exception for our platform exceptions
 */
@Getter
public class BaseException extends RuntimeException {
    protected Integer code;
    protected Integer httpCode;

    public BaseException(final String msg, final Integer code, final Integer httpCode) {
        super(msg);
        this.code = code;
        this.httpCode = httpCode;
    }

    public BaseException(final String msg, final Integer code, final Integer httpCode, final Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.httpCode = httpCode;
    }
}
