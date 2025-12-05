package com.lamarfishing.core.schedule.dto.response;

import com.lamarfishing.core.schedule.domain.Schedule;
import com.lamarfishing.core.schedule.dto.result.ViewDepartureTimeResult;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class ViewDepartureTimeResponse {
    private Boolean scheduleExist;
    private String schedulePublicId;
    private LocalDate date;
    private String dayOfWeek;
    private LocalTime dateTime;

    public static ViewDepartureTimeResponse from(ViewDepartureTimeResult result) {
        return ViewDepartureTimeResponse.builder()
                .scheduleExist(result.getScheduleExist())
                .schedulePublicId(result.getSchedulePublicId())
                .date(result.getDate())
                .dayOfWeek(result.getDayOfWeek())
                .dateTime(result.getDateTime())
                .build();
    }
}

