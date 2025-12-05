package com.lamarfishing.core.ship.dto.result;

import lombok.Builder;
import lombok.Data;

/**
 * 예약 상세 조회에 사용되는 dto
 */
@Data
@Builder
public class ReservationDetailShipDto {
    private String fishType;
    private String notification;
}
