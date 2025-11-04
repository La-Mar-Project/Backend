package com.lamarfishing.core.schedule.dto.response;

import com.lamarfishing.core.coupon.domain.Coupon;
import com.lamarfishing.core.coupon.dto.CouponCommonDto;
import com.lamarfishing.core.coupon.mapper.CouponMapper;
import com.lamarfishing.core.schedule.domain.Schedule;
import com.lamarfishing.core.ship.domain.Ship;
import com.lamarfishing.core.ship.dto.command.ShipDetailDto;
import com.lamarfishing.core.ship.mapper.ShipMapper;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ReservationPopupResponse {
    private ShipDetailDto ship;
    private UserCommonDto
    private String schedulePublicId;
    private LocalDateTime departure;
    private DayOfWeek dayOfWeek;
    private Integer tide;
    private List<CouponCommonDto> coupons;

    public static ReservationPopupResponse from(Schedule schedule, ShipDetailDto ship, List<Coupon> coupons) {
        return ReservationPopupResponse.builder()
                .ship(ship)
                .schedulePublicId(schedule.getPublicId())
                .departure(schedule.getDeparture())
                .dayOfWeek(schedule.getDeparture().getDayOfWeek())
                .tide(schedule.getTide())
                .coupons(coupons.stream()
                        .map(CouponMapper::toCouponCommonDto)
                        .toList())
                .build();
    }
}
