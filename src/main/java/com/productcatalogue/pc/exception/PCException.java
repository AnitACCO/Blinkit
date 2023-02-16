package com.productcatalogue.pc.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class PCException extends RuntimeException {
    private static final long serialVersionUID = 1l;

    public PCException(String message) {
        super(message);
    }

    public PCException(String message, Throwable cause) {
        super(message, cause);
    }
}
