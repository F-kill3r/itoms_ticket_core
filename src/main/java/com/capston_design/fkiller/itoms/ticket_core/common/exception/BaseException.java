package com.capston_design.fkiller.itoms.ticket_core.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final String message;
    private Object detail;

    private BaseException(HttpStatus httpStatus, String message, Object detail) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.detail = detail;
    }
    
    private BaseException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public static BaseException createBaseExceptionWithoutDetail(HttpStatus status, String message) {
        return new BaseException(status, message);
    }

    public static BaseException createBaseExceptionWithDetail(HttpStatus status, String message, Object detail) {
        return new BaseException(status, message, detail);
    }
}
