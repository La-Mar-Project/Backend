package com.lamarfishing.core.coupon.dummy;

import com.lamarfishing.core.coupon.domain.Coupon;
import com.lamarfishing.core.coupon.repository.CouponRepository;
import com.lamarfishing.core.user.domain.User;
import com.lamarfishing.core.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Order(2)
@RequiredArgsConstructor
public class CouponDummy {

    private final CouponRepository couponRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        if (couponRepository.count() > 0) {
            return;
        }

        List<User> users = userRepository.findAll();

        //각 유저마다 유효한 쿠폰 2개, 유효하지 않은 쿠폰 1개
        for (User user : users) {

            Coupon valid1 = Coupon.createDummy(
                    LocalDateTime.now().plusDays(30),
                    Coupon.Type.WEEKDAY,
                    user,
                    Coupon.Status.AVAILABLE
            );

            Coupon valid2 = Coupon.createDummy(
                    LocalDateTime.now().plusDays(20),
                    Coupon.Type.WEEKEND,
                    user,
                    Coupon.Status.AVAILABLE
            );

            Coupon invalid = Coupon.createDummy(
                    LocalDateTime.now().minusDays(1),
                    Coupon.Type.WEEKDAY,
                    user,
                    Coupon.Status.EXPIRED
            );

            couponRepository.save(valid1);
            couponRepository.save(valid2);
            couponRepository.save(invalid);
        }
    }
}
