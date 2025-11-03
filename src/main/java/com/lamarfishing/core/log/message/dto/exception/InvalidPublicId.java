package com.lamarfishing.core.log.message.dto.exception;

import com.lamarfishing.core.common.exception.BusinessException;
import com.lamarfishing.core.common.exception.ErrorCode;

public class InvalidPublicId extends BusinessException {
    public InvalidPublicId() {super(ErrorCode.INVALID_PUBLICId);}
}
