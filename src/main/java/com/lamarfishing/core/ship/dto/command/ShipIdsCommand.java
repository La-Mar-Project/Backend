package com.lamarfishing.core.ship.dto.command;

import com.lamarfishing.core.ship.dto.request.DeleteShipRequest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShipIdsCommand {
    private List<Long> shipIds;

    public static ShipIdsCommand from(DeleteShipRequest request){
        return ShipIdsCommand.builder().shipIds(request.getShipIds()).build();
    }
}
