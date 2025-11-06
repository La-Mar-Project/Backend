package com.lamarfishing.core.schedule.service;

import com.lamarfishing.core.reservation.domain.Reservation;
import com.lamarfishing.core.reservation.dto.command.ReservationCommonDto;
import com.lamarfishing.core.reservation.mapper.ReservationMapper;
import com.lamarfishing.core.reservation.repository.ReservationRepository;
import com.lamarfishing.core.schedule.domain.Schedule;
import com.lamarfishing.core.schedule.dto.command.ScheduleCommonDto;
import com.lamarfishing.core.schedule.dto.response.ScheduleDetailResponse;
import com.lamarfishing.core.schedule.exception.ScheduleInvalidPublicId;
import com.lamarfishing.core.schedule.exception.ScheduleNotFound;
import com.lamarfishing.core.schedule.mapper.ScheduleMapper;
import com.lamarfishing.core.schedule.repository.ScheduleRepository;
import com.lamarfishing.core.ship.domain.Ship;
import com.lamarfishing.core.ship.dto.command.ShipCommonDto;
import com.lamarfishing.core.ship.mapper.ShipMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ReservationRepository reservationRepository;

    public ScheduleDetailResponse getScheduleDetail(String publicId){
        if (!publicId.startsWith("sch")) {
            throw new ScheduleInvalidPublicId();
        }

        Schedule schedule = scheduleRepository.findByPublicId(publicId).orElseThrow(ScheduleNotFound::new);
        ScheduleCommonDto scheduleCommonDto = ScheduleMapper.toScheduleCommonDto(schedule);

        Ship ship = schedule.getShip();
        ShipCommonDto shipCommonDto = ShipMapper.toShipCommonResponse(ship);

        List<ReservationCommonDto> reservations =
                reservationRepository.findBySchedule(schedule)
                        .stream()
                        .map(ReservationMapper::toReservationCommonDto)
                        .toList();

        ScheduleDetailResponse scheduleDetailResponse = ScheduleDetailResponse.from(shipCommonDto, scheduleCommonDto, reservations);

        return scheduleDetailResponse;
    }

}
