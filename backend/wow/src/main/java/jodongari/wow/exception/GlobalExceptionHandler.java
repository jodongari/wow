package jodongari.wow.exception;

import jodongari.wow.protocol.ErrorResponse;
import jodongari.wow.protocol.ResultResponse;
import jodongari.wow.video.exception.VideoErrorCode;
import jodongari.wow.video.exception.VideoException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VideoException.class)
    protected ResponseEntity<ResultResponse> handleVideoException(final VideoException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus().value())
                .body(ResultResponse.builder()
                        .success(false)
                        .response(null)
                        .error(new ErrorResponse(
                                e.getErrorCode().getStatus().value(),
                                e.getErrorCode().getStatus().name(),
                                e.getErrorCode().getMessage()))
                        .build());
    }

    @ExceptionHandler(value={ BindException.class, MethodArgumentNotValidException.class })
    protected ResponseEntity<ResultResponse> handleGlobalException(final Exception e) {
        VideoErrorCode errorCode = VideoErrorCode.METHOD_ARGUMENT_NOT_VALID;

        return ResponseEntity
                .status(VideoErrorCode.METHOD_ARGUMENT_NOT_VALID.getStatus().value())
                .body(ResultResponse.builder()
                        .success(false)
                        .response(null)
                        .error(new ErrorResponse(
                                errorCode.getStatus().value(),
                                errorCode.getStatus().name(),
                                errorCode.getMessage()))
                        .build());
    }

}
