package com.lamarfishing.core.ship.mapper;

import com.lamarfishing.core.ship.domain.Ship;
import com.lamarfishing.core.ship.dto.command.ShipCommonDto;
import com.lamarfishing.core.ship.dto.command.ShipDetailDto;

public class ShipMapper {

    public static ShipCommonDto toShipCommonResponse(Ship ship){
        return ShipCommonDto.builder()
                .shipId(ship.getId())
                .fishType(ship.getFishType())
                .price(ship.getPrice())
                .build();
    }

    public static ShipDetailDto toShipDetailResponse(Ship ship){
        return ShipDetailDto.builder()
                .shipId(ship.getId())
                .fishType(ship.getFishType())
                .price(ship.getPrice())
                .maxHeadCount(ship.getMaxHeadCount())
                .notification(ship.getNotification())
                .build();
    }
}
