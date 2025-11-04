package com.lamarfishing.core.user.exception;

import com.lamarfishing.core.common.exception.BusinessException;
import com.lamarfishing.core.common.exception.ErrorCode;

public class UserNotFound extends BusinessException {
    public UserNotFound(String message) {super(ErrorCode.USER_NOT_FOUND);}
}
