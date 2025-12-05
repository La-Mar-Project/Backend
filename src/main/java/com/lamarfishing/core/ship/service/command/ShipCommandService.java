package com.lamarfishing.core.ship.service.command;

import com.lamarfishing.core.ship.domain.Ship;
import com.lamarfishing.core.ship.dto.command.ShipCommand;
import com.lamarfishing.core.ship.dto.command.ShipIdsCommand;
import com.lamarfishing.core.ship.exception.ShipNotFound;
import com.lamarfishing.core.ship.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ShipCommandService {

    private final ShipRepository shipRepository;

    // @PreAuthorize("hasAuthority('GRADE_ADMIN')")
    public void createShip(ShipCommand command) {

        Ship ship = Ship.create(command.getMaxHeadCount(), command.getFishType(), command.getPrice(), command.getNotification());
        shipRepository.save(ship);

    }

    // @PreAuthorize("hasAuthority('GRADE_ADMIN')")
    public void updateShip( Long shipId, ShipCommand command) {

        Ship ship = shipRepository.findById(shipId).orElseThrow(ShipNotFound::new);

        if (command.getFishType() != null){
            ship.updateFishType(command.getFishType());
        }
        if(command.getPrice() != null){
            ship.updatePrice(command.getPrice());
        }
        if(command.getMaxHeadCount() != null){
            ship.updateMaxHeadCount(command.getMaxHeadCount());
        }
        if(command.getNotification() !=null){
            ship.updateNotification(command.getNotification());
        }
    }

    // @PreAuthorize("hasAuthority('GRADE_ADMIN')")
    public void deleteShip(ShipIdsCommand command) {

        List<Ship> ships = shipRepository.findAllById(command.getShipIds());

        if (ships.size() != command.getShipIds().size()) {
            throw new ShipNotFound();
        }
        shipRepository.deleteAllInBatch(ships);
    }
}
