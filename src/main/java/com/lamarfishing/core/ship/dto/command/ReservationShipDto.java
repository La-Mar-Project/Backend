package com.lamarfishing.core.ship.dto.command;

import lombok.Builder;
import lombok.Data;

/**
 * 예약 팝업 조회에 사용되는 dto
 */
@Data
@Builder
public class ReservationShipDto {
    private String fishType;
    private Integer price;
    private String notification;
}
