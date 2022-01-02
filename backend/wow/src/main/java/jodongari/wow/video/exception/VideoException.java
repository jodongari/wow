package jodongari.wow.video.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VideoException extends RuntimeException {
    private VideoErrorCode errorCode;

}
