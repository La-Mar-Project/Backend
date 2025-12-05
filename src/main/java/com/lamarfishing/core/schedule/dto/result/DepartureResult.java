package com.lamarfishing.core.schedule.dto.result;

import com.lamarfishing.core.message.dto.command.MessageCommonDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DepartureResult {
    private List<MessageCommonDto> messages;

    public static DepartureResult from(List<MessageCommonDto> messages) {
        return DepartureResult.builder()
                .messages(messages)
                .build();
    }
}
