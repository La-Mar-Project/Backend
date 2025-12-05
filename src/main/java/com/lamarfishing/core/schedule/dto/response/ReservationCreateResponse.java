package com.lamarfishing.core.schedule.dto.response;

import com.lamarfishing.core.schedule.dto.result.ReservationCreateResult;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationCreateResponse {
    private String reservationPublicId;

    public static ReservationCreateResponse from(ReservationCreateResult reservationCreateResult) {
        return ReservationCreateResponse.builder()
                .reservationPublicId(reservationCreateResult.getReservationPublicId())
                .build();
    }
}
