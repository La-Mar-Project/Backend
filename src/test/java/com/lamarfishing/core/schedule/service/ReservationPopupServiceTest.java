package com.lamarfishing.core.schedule.service;

import com.lamarfishing.core.coupon.repository.CouponRepository;
import com.lamarfishing.core.schedule.controller.ReservationPopupController;
import com.lamarfishing.core.schedule.exception.ScheduleInvalidPublicId;
import com.lamarfishing.core.schedule.repository.ScheduleRepository;
import com.lamarfishing.core.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReservationPopupServiceTest {

    @InjectMocks
    private ReservationPopupService reservationPopupService;

    @Mock
    private ScheduleRepository scheduleRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CouponRepository couponRepository;

    @DisplayName("publicId가 schedule이 아니면 ScheduleInvalidPublicId 예외를 발생시킨다.")
    @Test
    void getReservationPopup_publicId가_schedule_것이_아니면_예외() {
        // given
        Long userId = 1L;
        String grade = "BASIC";
        String invalidPublicId = "res-123";

        // when & then

        assertThatThrownBy(() ->
                reservationPopupService.getReservationPopup(userId, grade, invalidPublicId)
        ).isInstanceOf(ScheduleInvalidPublicId.class);
    }
}