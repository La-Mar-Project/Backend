package com.lamarfishing.core.schedule.dto.response;

import com.lamarfishing.core.message.dto.command.MessageCommonDto;
import com.lamarfishing.core.schedule.dto.result.DepartureResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DepartureResponse {
    private List<MessageCommonDto> messages;

    public static DepartureResponse from(DepartureResult result) {
        return DepartureResponse.builder()
                .messages(result.getMessages())
                .build();
    }
}
