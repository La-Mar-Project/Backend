package com.lamarfishing.core.schedule.dto.request;

import com.lamarfishing.core.coupon.domain.Coupon;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationPopupRequest {
    private String username;
    private String nickname;
    private String phone;
    private Integer headCount;
    private String request;
    private Coupon coupon;
}
