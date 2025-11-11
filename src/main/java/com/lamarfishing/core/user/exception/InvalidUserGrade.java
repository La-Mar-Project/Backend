package com.lamarfishing.core.user.exception;

import com.lamarfishing.core.common.exception.BusinessException;
import com.lamarfishing.core.common.exception.ErrorCode;

public class InvalidUserGrade extends BusinessException {
    public InvalidUserGrade(){super(ErrorCode.INVALID_USER_GRADE);}
}
