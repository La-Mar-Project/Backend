package com.lamarfishing.core.ship.controller;

import com.lamarfishing.core.common.dto.response.ApiResponse;
import com.lamarfishing.core.common.dto.response.PageResponse;
import com.lamarfishing.core.ship.dto.command.ShipCommand;
import com.lamarfishing.core.ship.dto.command.ShipIdsCommand;
import com.lamarfishing.core.ship.dto.result.ShipDetailDto;
import com.lamarfishing.core.ship.dto.request.CreateShipRequest;
import com.lamarfishing.core.ship.dto.request.DeleteShipRequest;
import com.lamarfishing.core.ship.dto.request.UpdateShipRequest;
import com.lamarfishing.core.ship.dto.response.ShipDetailResponse;
import com.lamarfishing.core.ship.service.query.ShipQueryService;
import com.lamarfishing.core.ship.service.command.ShipCommandService;
import com.lamarfishing.core.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ships")
@RequiredArgsConstructor
public class ShipController {

    private final ShipQueryService shipQueryService;
    private final ShipCommandService shipCommandService;
    /**
     * 배 리스트 조회 / 스케쥴 생성할 때 필요한 조회
     */
    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<ShipDetailDto>>> getShips(Pageable pageable){

        Page<ShipDetailDto> result = shipQueryService.getShips(pageable);

        return ResponseEntity.ok(ApiResponse.success("배 리스트 조회에 성공하였습니다.",PageResponse.from(result)));
    }

    /**
     * 배 생성 api
     */
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createShip(//@AuthenticationPrincipal AuthenticatedUser authenticatedUser,
                                                        @RequestBody CreateShipRequest req){

        // User user = userService.findUser(authenticatedUser);
        shipCommandService.createShip(ShipCommand.from(req));
        return ResponseEntity.ok(ApiResponse.success("배 생성에 성공하였습니다."));
    }

    /**
     * 배 수정 api
     */
    @PutMapping("/{shipId}")
    public ResponseEntity<ApiResponse<Void>> updateShip(// @AuthenticationPrincipal AuthenticatedUser authenticatedUser,
                                                        @RequestBody UpdateShipRequest req,
                                                        @PathVariable Long shipId){

        // User user = userService.findUser(authenticatedUser);

        shipCommandService.updateShip(shipId, ShipCommand.from(req));

        return ResponseEntity.ok(ApiResponse.success("배 수정에 성공"));
    }

    /**
     * 배 삭제 api
     */
    @PostMapping("/delete")
    public ResponseEntity<ApiResponse<Void>> deleteShip(@RequestBody DeleteShipRequest request){

        shipCommandService.deleteShip(ShipIdsCommand.from(request));

        return ResponseEntity.ok(ApiResponse.success("배 삭제에 성공하였습니다."));
    }


}
