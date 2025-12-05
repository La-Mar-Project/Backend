package com.lamarfishing.core.schedule.dto.command;

import com.lamarfishing.core.schedule.dto.request.UpdateDepartureTimeRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class UpdateDepartureTimeCommand {
    private LocalTime departureTime;

    public static UpdateDepartureTimeCommand from(UpdateDepartureTimeRequest req) {
        return  UpdateDepartureTimeCommand.builder()
                .departureTime(req.getDepartureTime())
                .build();
    }
}