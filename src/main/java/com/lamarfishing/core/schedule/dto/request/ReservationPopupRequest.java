package com.lamarfishing.core.schedule.dto.request;

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

}
