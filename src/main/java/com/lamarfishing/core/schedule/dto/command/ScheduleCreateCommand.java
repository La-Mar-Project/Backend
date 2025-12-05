package com.lamarfishing.core.schedule.dto.command;

import com.lamarfishing.core.schedule.domain.Type;
import com.lamarfishing.core.schedule.dto.request.ScheduleCreateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ScheduleCreateCommand {
    private LocalDate startDate;    //예약 시작 날짜
    private LocalDate endDate;      //예약
    private Long shipId;
    private Type scheduleType;

    public static ScheduleCreateCommand from(ScheduleCreateRequest request){
        return ScheduleCreateCommand.builder()
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .shipId(request.getShipId())
                .scheduleType(request.getScheduleType())
                .build();
    }
}
