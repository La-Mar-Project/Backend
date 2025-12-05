package com.lamarfishing.core.message.service.command;

import com.lamarfishing.core.message.dto.command.MessageCommonDto;
import com.lamarfishing.core.message.dto.exception.MessageSendFailedException;
import com.lamarfishing.core.schedule.domain.Status;
import com.solapi.sdk.SolapiClient;
import com.solapi.sdk.message.model.Message;
import com.solapi.sdk.message.service.DefaultMessageService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageCommandService {

    private DefaultMessageService messageService;

    @Value("${solapi.sender}")
    private String senderNumber;

    @Value("${solapi.api-key}")
    private String apiKey;

    @Value("${solapi.api-secret}")
    private String apiSecret;

    @PostConstruct
    public void initSolapi() {
        this.messageService = SolapiClient.INSTANCE.createInstance(apiKey, apiSecret);
    }

    @PreAuthorize("hasAuthority('GRADE_ADMIN')")
    public List<MessageCommonDto> sendMessage(List<String> phones, Status status) {
        return doSendMessage(phones, status.message());
    }

    @PreAuthorize("hasAuthority('GRADE_ADMIN')")
    public List<MessageCommonDto> sendMessage(List<String> phones, String content) {
        return doSendMessage(phones, content);
    }

    private List<MessageCommonDto> doSendMessage(List<String> phones, String content) {

        List<String> failedPhones = new ArrayList<>();
        List<MessageCommonDto> results = new ArrayList<>();

        for (String to : phones) {
            Message msg = new Message();
            msg.setFrom(senderNumber);
            msg.setTo(to);
            msg.setText(content);

            try {
                messageService.send(msg);
            } catch (Exception e) {
                failedPhones.add(to);
            }
        }

        if (!failedPhones.isEmpty()) {
            throw new MessageSendFailedException("전송 실패: " + failedPhones, failedPhones);
        }

        return results;
    }
}
