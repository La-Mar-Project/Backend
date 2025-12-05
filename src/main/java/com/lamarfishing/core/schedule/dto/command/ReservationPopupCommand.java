package com.lamarfishing.core.schedule.dto.command;

import com.lamarfishing.core.schedule.dto.request.ReservationPopupRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationPopupCommand {
    private String username;
    private String nickname;
    private String phone;
    private Integer headCount;
    private String request;
    private Long couponId;

    public static ReservationPopupCommand from(ReservationPopupRequest request) {
        return ReservationPopupCommand.builder()
                .username(request.getUsername())
                .nickname(request.getNickname())
                .phone(request.getPhone())
                .headCount(request.getHeadCount())
                .couponId(request.getCouponId())
                .build();
    }
}
