package com.lamarfishing.core.schedule.dto.result;


import com.lamarfishing.core.schedule.domain.Schedule;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ViewDepartureTimeResult {
    private Boolean scheduleExist;
    private String schedulePublicId;
    private LocalDate date;
    private String dayOfWeek;
    private LocalTime dateTime;

    public static ViewDepartureTimeResult of(Boolean scheduleExist, Schedule schedule){
        return ViewDepartureTimeResult.builder()
                .scheduleExist(scheduleExist)
                .schedulePublicId(schedule.getPublicId())
                .date(schedule.getDeparture().toLocalDate())
                .dayOfWeek(schedule.getDeparture().toLocalDate().getDayOfWeek().toString())
                .dateTime(schedule.getDeparture().toLocalTime())
                .build();
    }

    public static ViewDepartureTimeResult of(Boolean scheduleExist, LocalDate date){
        return ViewDepartureTimeResult.builder()
                .scheduleExist(scheduleExist)
                .schedulePublicId(null)
                .date(date)
                .dayOfWeek(date.getDayOfWeek().toString())
                .dateTime(null)
                .build();
    }
}
