package com.lamarfishing.core.schedule.dto.response;

import com.lamarfishing.core.schedule.domain.Schedule;
import com.lamarfishing.core.ship.dto.command.ReservationShipDto;
import com.lamarfishing.core.user.dto.command.EarlyReservationUserDto;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * 선예약 팝업 조회
 */
@Data
@Builder
public class EarlyReservationPopupResponse {
    private ReservationShipDto ship;
    private EarlyReservationUserDto user;
    private String schedulePublicId;
    private Integer remainHeadCount;
    private LocalDateTime departure;
    private DayOfWeek dayOfWeek;
    private Integer tide;

    public static EarlyReservationPopupResponse from(Schedule schedule, Integer remainHeadCount, EarlyReservationUserDto user, ReservationShipDto ship) {
        return EarlyReservationPopupResponse.builder()
                .ship(ship)
                .user(user)
                .schedulePublicId(schedule.getPublicId())
                .remainHeadCount(remainHeadCount)
                .departure(schedule.getDeparture())
                .dayOfWeek(schedule.getDeparture().getDayOfWeek())
                .tide(schedule.getTide())
                .build();
    }
}
