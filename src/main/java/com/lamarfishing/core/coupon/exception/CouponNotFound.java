package com.lamarfishing.core.coupon.exception;

import com.lamarfishing.core.common.exception.BusinessException;
import com.lamarfishing.core.common.exception.ErrorCode;

public class CouponNotFound extends BusinessException {
    public CouponNotFound(){super(ErrorCode.COUPON_NOT_FOUND);}
}
