package com.lamarfishing.core.schedule.service;

import com.lamarfishing.core.schedule.domain.Schedule;
import com.lamarfishing.core.schedule.dto.response.ReservationPopupResponse;
import com.lamarfishing.core.schedule.exception.ScheduleInvalidPublicId;
import com.lamarfishing.core.schedule.exception.ScheduleNotFound;
import com.lamarfishing.core.schedule.repository.ScheduleRepository;
import com.lamarfishing.core.ship.domain.Ship;
import com.lamarfishing.core.user.domain.User;
import com.lamarfishing.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationPopupService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ReservationPopupResponse getReservationPopup(Long userId, String userName, User.Grade grade, String publicId){
        if (!publicId.startsWith("sch")) {
            throw new ScheduleInvalidPublicId();
        }

        Schedule schedule = scheduleRepository.findByPublicId(publicId).orElseThrow(ScheduleNotFound::new);
        Ship ship = schedule.getShip();
        User user = userRepository.findById(userId).orElseThrow(UserNot);

    }
}
