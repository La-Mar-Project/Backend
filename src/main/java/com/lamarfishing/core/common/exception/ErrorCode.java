package com.lamarfishing.core.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_PUBLICId(HttpStatus.BAD_REQUEST, "Invalid publicId format");

    private final HttpStatus status;
    private final String message;
}
