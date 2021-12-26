package jodongari.wow.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* valid exception */
    METHOD_ARGUMENT_NOT_VALID(HttpStatus.BAD_REQUEST, "유효하지 않은 인자입니다. 다시 확인해주세요."),

    /* 400 exception */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    /* 401 exception */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "유효한 인증자격이 없습니다. "),

    /* 403 exception */
    FORBIDDEN(HttpStatus.FORBIDDEN, "접근 권한이 없습니다."),

    /* 404 exception */
    NOT_FOUND(HttpStatus.NOT_FOUND, "페이지를 찾을 수 없습니다."),

    /* 405 exception */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다.");

    private final HttpStatus status;
    private final String message;

}
