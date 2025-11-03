package com.lamarfishing.core.log.message.dto.service;

import com.solapi.sdk.message.service.DefaultMessageService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

public class MessageService {
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
}
