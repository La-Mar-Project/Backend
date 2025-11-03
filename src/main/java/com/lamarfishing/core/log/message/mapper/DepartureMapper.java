package com.lamarfishing.core.log.message.mapper;

import com.lamarfishing.core.log.message.domain.MessageLog;
import com.lamarfishing.core.log.message.dto.command.MessageCommonDto;
import com.lamarfishing.core.log.message.dto.response.DepartureResponse;

public class DepartureMapper {
    public static MessageCommonDto toMessage(MessageLog message){
        return MessageCommonDto.builder()
                .timeStamp(message.getTimeStamp())
                .recipientPhone(message.getRecipientPhone())
                .content(message.getContent())
                .build();
    }
}
