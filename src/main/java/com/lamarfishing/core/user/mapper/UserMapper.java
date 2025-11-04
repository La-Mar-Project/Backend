package com.lamarfishing.core.user.mapper;

import com.lamarfishing.core.coupon.domain.Coupon;
import com.lamarfishing.core.coupon.dto.CouponCommonDto;
import com.lamarfishing.core.coupon.dto.ProfileCouponDto;
import com.lamarfishing.core.user.domain.User;
import com.lamarfishing.core.user.dto.command.MyProfileDto;
import com.lamarfishing.core.user.dto.command.ReservationUserDto;

import java.util.List;

public class UserMapper {

    public static MyProfileDto toMyProfileDto(User user, List<ProfileCouponDto> coupons) {
        return MyProfileDto.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .grade(user.getGrade())
                .phone(user.getPhone())
                .coupons(coupons)
                .build();
    }

    public static ReservationUserDto toReservationUserDto(User user, List<CouponCommonDto> coupons) {
        return ReservationUserDto.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .grade(user.getGrade())
                .phone(user.getPhone())
                .coupons(coupons)
                .build();
    }
}
