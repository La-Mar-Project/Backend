package com.lamarfishing.core.ship.dto.command;

import com.lamarfishing.core.ship.dto.request.CreateShipRequest;
import com.lamarfishing.core.ship.dto.request.UpdateShipRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipCommand {
    private String fishType;
    private Integer price;
    private Integer maxHeadCount;
    private String notification;

    public static ShipCommand from(CreateShipRequest request){
        return ShipCommand.builder()
                .fishType(request.getFishType())
                .price(request.getPrice())
                .maxHeadCount(request.getMaxHeadCount())
                .notification(request.getNotification())
                .build();
    }

    public static ShipCommand from(UpdateShipRequest request){
        return ShipCommand.builder()
                .fishType(request.getFishType())
                .price(request.getPrice())
                .maxHeadCount(request.getMaxHeadCount())
                .notification(request.getNotification())
                .build();
    }

}