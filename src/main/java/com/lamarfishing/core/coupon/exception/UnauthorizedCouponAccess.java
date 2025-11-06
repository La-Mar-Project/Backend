package com.lamarfishing.core.coupon.exception;

import com.lamarfishing.core.common.exception.ErrorCode;

public class UnauthorizedCouponAccess extends RuntimeException {
    public UnauthorizedCouponAccess() {
        super(ErrorCode.UNAUTHORIZED_COUPON_ACCESS);
    }
}
