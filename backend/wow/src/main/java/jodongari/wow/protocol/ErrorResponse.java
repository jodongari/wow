package jodongari.wow.protocol;

import jodongari.wow.exception.ErrorCode;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int status;
    private final String name;
    private final String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus().value();
        this.name = errorCode.getStatus().name();
        this.message = errorCode.getMessage();
    }
}
