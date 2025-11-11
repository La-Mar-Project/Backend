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
    private Long couponId;

    //생성자
    public ReservationPopupRequest(String username, String nickname, String phone, Integer headCount, String request, Long couponId) {
        this.username = username;
        this.nickname = nickname;
        this.phone = phone;
        this.headCount = headCount;
        this.request = request;
        this.couponId = couponId;
    }
}
