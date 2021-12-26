package jodongari.wow.exception;

import jodongari.wow.protocol.ErrorResponse;
import jodongari.wow.protocol.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    protected ResponseEntity<ResultResponse> handleGlobalException(final GlobalException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus().value())
                .body(ResultResponse.builder()
                        .success(false)
                        .response(null)
                        .error(new ErrorResponse(e.getErrorCode()))
                        .build());
    }

    @ExceptionHandler(value={ BindException.class, MethodArgumentNotValidException.class })
    protected ResponseEntity<ResultResponse> handleGlobalException(final Exception e) {
        return ResponseEntity
                .status(ErrorCode.METHOD_ARGUMENT_NOT_VALID.getStatus().value())
                .body(ResultResponse.builder()
                        .success(false)
                        .response(null)
                        .error(new ErrorResponse(ErrorCode.METHOD_ARGUMENT_NOT_VALID))
                        .build());
    }

}
