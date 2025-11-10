package com.lamarfishing.core.coupon.dto;

import com.lamarfishing.core.coupon.domain.Coupon;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProfileCouponDto {
    private Coupon.Type type;
    private LocalDateTime expiresAt;
}
