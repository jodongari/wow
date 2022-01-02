package jodongari.wow.protocol;

import jodongari.wow.video.exception.VideoErrorCode;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int status;
    private final String name;
    private final String message;

    public ErrorResponse(int status, String name, String message) {
        this.status = status;
        this.name = name;
        this.message = message;
    }
}
