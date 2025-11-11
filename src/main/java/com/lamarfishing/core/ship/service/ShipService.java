package com.lamarfishing.core.ship.service;

import com.lamarfishing.core.ship.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShipService {

    private final ShipRepository shipRepository;

    public
}
