package com.lamarfishing.core.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /**
     * common
     */
    INVALID_PUBLICId(HttpStatus.BAD_REQUEST, "Invalid publicId format"),
    INVALID_REQUEST_CONTENT(HttpStatus.BAD_REQUEST, "Invalid request content"),
    /**
     * schedule
     */
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "Schedule not found");

    private final HttpStatus status;
    private final String message;
}
