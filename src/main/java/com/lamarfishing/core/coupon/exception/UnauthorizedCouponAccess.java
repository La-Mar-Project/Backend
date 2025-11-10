package com.lamarfishing.core.coupon.exception;

import com.lamarfishing.core.common.exception.BusinessException;
import com.lamarfishing.core.common.exception.ErrorCode;

public class UnauthorizedCouponAccess extends BusinessException {
    public UnauthorizedCouponAccess() {
        super(ErrorCode.UNAUTHORIZED_COUPON_ACCESS);
    }
}
