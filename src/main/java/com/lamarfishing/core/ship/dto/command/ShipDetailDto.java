package com.lamarfishing.core.ship.dto.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipDetailDto {
    private Long shipId;
    private String fishType;
    private Integer price;
    private Integer maxHeadCount;
    private String notification;
}
