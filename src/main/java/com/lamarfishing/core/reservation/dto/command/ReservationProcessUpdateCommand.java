package com.lamarfishing.core.reservation.dto.command;

import com.lamarfishing.core.reservation.domain.Reservation;
import com.lamarfishing.core.reservation.dto.request.ReservationProcessUpdateRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationProcessUpdateCommand {
    private Reservation.Process process;

    public static  ReservationProcessUpdateCommand from(ReservationProcessUpdateRequest request) {
        return ReservationProcessUpdateCommand.builder()
                .process(request.getProcess())
                .build();
    }
}
