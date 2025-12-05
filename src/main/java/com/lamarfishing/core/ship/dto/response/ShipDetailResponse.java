package com.lamarfishing.core.ship.dto.response;

import com.lamarfishing.core.ship.dto.result.ShipDetailDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipDetailResponse {
    ShipDetailDto ship;

    public static ShipDetailResponse from(ShipDetailDto ship){
        return ShipDetailResponse.builder()
                .ship(ship)
                .build();
    }
}
