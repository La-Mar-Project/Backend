package com.lamarfishing.core.schedule.service;

import static org.mockito.ArgumentMatchers.any;

//@ExtendWith(MockitoExtension.class)
//class ReservationPopupServiceTest {
//
//    @InjectMocks
//    private ReservationPopupService reservationPopupService;
//
//    @Mock
//    private ScheduleRepository scheduleRepository;
//    @Mock
//    private UserRepository userRepository;
//    @Mock
//    private CouponRepository couponRepository;
//    @Mock
//    private ReservationRepository reservationRepository;
//
//    /**
//     * 로직 쫙 바뀌면서 수정 필요
//     */
//    /**
//     * getReservationPopup
//     */
//    @DisplayName("getReservationPopup: publicId가 schedule이 아니면 InvalidSchedulePublicId 예외를 발생시킨다.")
//    @Test
//    void getReservationPopup_publicId가_schedule_것이_아니면_예외() {
//        // given
//        Long userId = 1L;
//        String grade = "BASIC";
//        String invalidPublicId = "res-123";
//
//        // when, then
//        assertThatThrownBy(() ->
//                reservationPopupService.getReservationPopup(userId, invalidPublicId)
//        ).isInstanceOf(InvalidSchedulePublicId.class);
//    }
//
//    @DisplayName("getResrvationPopup: user가 존재하지 않을 시 UserNotFound")
//    @Test
//    void getReservationPopup_userNotFound() {
//        // given
//        Long userId = 1L;
//        String publicId = "sch-123123";
//
//        when(userRepository.findById(userId)).thenReturn(Optional.empty());
//
//        // when & then
//        assertThatThrownBy(() ->
//                reservationPopupService.getReservationPopup(userId, publicId)
//        ).isInstanceOf(UserNotFound.class);
//    }
//
//    @DisplayName("getReservationPopup: 회원 정상 조회")
//    @Test
//    void getReservationPopup_BASIC() {
//        //given
//        Ship ship = Ship.create(20, "쭈갑", 90000, "주의사항 없음");
//
//        Schedule schedule = Schedule.create(LocalDateTime.of(2025, 11, 5, 0, 0),
//                5, 3, Status.WAITING, Type.NORMAL, ship);
//
//        User user = User.create("김지오", "geooeg", User.Grade.BASIC, "01012345678");
//        Coupon coupon1 = Coupon.create(Coupon.Type.WEEKDAY, user);
//        Coupon coupon2 = Coupon.create(Coupon.Type.WEEKEND, user);
//
//        List<Coupon> couponEntities = List.of(coupon1, coupon2);
//        List<CouponCommonDto> coupons = couponEntities.stream()
//                .map(CouponMapper::toCouponCommonDto)
//                .toList();
//
//        Long userId = 1L;
//        String publicId = schedule.getPublicId();
//
//        //when
//        when(scheduleRepository.findByPublicId(publicId)).thenReturn(Optional.of(schedule));
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//        when(couponRepository.findByUserAndStatus(user, Coupon.Status.AVAILABLE)).thenReturn(couponEntities);
//
//        EarlyReservationPopupResponse response =
//                reservationPopupService.getReservationPopup(userId, publicId);
//
//        //then
//        assertThat(response).isNotNull();
//        //ship
//        assertThat(response.getShip().getFishType()).isEqualTo(ship.getFishType());
//        assertThat(response.getShip().getPrice()).isEqualTo(ship.getPrice());
//        assertThat(response.getShip().getNotification()).isEqualTo(ship.getNotification());
//        //user
//        assertThat(response.getUser().getUsername()).isEqualTo(user.getUsername());
//        assertThat(response.getUser().getNickname()).isEqualTo(user.getNickname());
//        assertThat(response.getUser().getGrade()).isEqualTo(user.getGrade());
//        assertThat(response.getUser().getPhone()).isEqualTo(user.getPhone());
//        assertThat(response.getUser().getCoupons()).isEqualTo(coupons);
//        //schedule
//        assertThat(response.getSchedulePublicId()).isEqualTo(publicId);
//        assertThat(response.getDeparture()).isEqualTo(schedule.getDeparture());
//        assertThat(response.getTide()).isEqualTo(schedule.getTide());
//        assertThat(response.getRemainHeadCount()).isEqualTo(ship.getMaxHeadCount() - schedule.getCurrentHeadCount());
//        assertThat(response.getDayOfWeek()).isEqualTo((schedule.getDeparture().getDayOfWeek()));
//        assertThat(response.getTide()).isEqualTo(schedule.getTide());
//
//    }
//
//    @DisplayName("getReservationPopup: 비회원 정상 조회")
//    @Test
//    void getReservationPopup_GUEST() {
//        //given
//        String GUEST_USERNAME = "비회원_이름";
//        String GUEST_NICKNAME = "비회원_닉네임";
//        String GUEST_PHONE = "비회원_전화번호";
//
//        Ship ship = Ship.create(20, "쭈갑", 90000, "주의사항 없음");
//
//        Schedule schedule = Schedule.create(LocalDateTime.of(2025, 11, 5, 0, 0),
//                5, 3, Status.WAITING, Type.NORMAL, ship);
//
//        User user = User.create("김지오", "geooeg", User.Grade.GUEST, "01012345678");  //사실 없는 객체임
//
//        Long userId = 1L;
//        String publicId = schedule.getPublicId();
//
//        //when
//        when(scheduleRepository.findByPublicId(publicId)).thenReturn(Optional.of(schedule));
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//
//        EarlyReservationPopupResponse response =
//                reservationPopupService.getReservationPopup(userId, publicId);
//
//        //then
//        assertThat(response).isNotNull();
//        //ship
//        assertThat(response.getShip().getFishType()).isEqualTo(ship.getFishType());
//        assertThat(response.getShip().getPrice()).isEqualTo(ship.getPrice());
//        assertThat(response.getShip().getNotification()).isEqualTo(ship.getNotification());
//        //user
//        assertThat(response.getUser().getUsername()).isEqualTo(GUEST_USERNAME);
//        assertThat(response.getUser().getNickname()).isEqualTo(GUEST_NICKNAME);
//        assertThat(response.getUser().getGrade()).isEqualTo(user.getGrade());
//        assertThat(response.getUser().getPhone()).isEqualTo(GUEST_PHONE);
//        assertThat(response.getUser().getCoupons()).isEmpty();
//        //schedule
//        assertThat(response.getSchedulePublicId()).isEqualTo(publicId);
//        assertThat(response.getDeparture()).isEqualTo(schedule.getDeparture());
//        assertThat(response.getTide()).isEqualTo(schedule.getTide());
//        assertThat(response.getRemainHeadCount()).isEqualTo(ship.getMaxHeadCount() - schedule.getCurrentHeadCount());
//        assertThat(response.getDayOfWeek()).isEqualTo((schedule.getDeparture().getDayOfWeek()));
//        assertThat(response.getTide()).isEqualTo(schedule.getTide());
//
//    }
//
//    /**
//     * createReservation
//     */
//    @DisplayName("createReservation: publicId가 schedule이 아니면 InvalidSchedulePublicId 예외를 발생시킨다.")
//    @Test
//    void createReservation_publicId가_schedule_것이_아니면_예외() {
//        // given
//        Long userId = 1L;
//        String grade = "BASIC";
//        String invalidPublicId = "res-123";
//
//        // when, then
//        assertThatThrownBy(() ->
//                reservationPopupService.createReservation(userId, invalidPublicId, null)
//        ).isInstanceOf(InvalidSchedulePublicId.class);
//    }
//
//    @DisplayName("createReservation: BASIC 회원 정상 로직 - Response Body/ Reservation 검증")
//    @Test
//    void createReservation_BASIC_Reservation_검증() {
//        Long userId = 1L;
//        String publicId = "sch-001";
//
//        User user = User.create("김지오", "geo", User.Grade.BASIC, "01012341234");
//        Ship ship = Ship.create(20, "쭈갑", 90000, "주의사항 없음");
//
//        Schedule schedule = Schedule.create(
//                LocalDateTime.of(2025, 11, 5, 0, 0),
//                5,
//                3,
//                Status.WAITING,
//                Type.NORMAL,
//                ship
//        );
//
//        Coupon coupon = Coupon.create(Coupon.Type.WEEKDAY, user);
//        ReflectionTestUtils.setField(coupon, "id", 10L);
//        Long couponId = coupon.getId();
//
//        // repository mock stubbing
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//        when(scheduleRepository.findByPublicId(publicId)).thenReturn(Optional.of(schedule));
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//        when(reservationRepository.save(any()))
//                .thenAnswer(invocation -> invocation.getArgument(0));
//        when(couponRepository.findById(couponId)).thenReturn(Optional.of(coupon));
//        ReservationPopupRequest request = ReservationPopupRequest.builder()
//                .headCount(2)
//                .request("내가 왕이다.")
//                .couponId(coupon.getId())
//                .build();
//
//        ArgumentCaptor<Reservation> captor = ArgumentCaptor.forClass(Reservation.class);
//
//        ReservationCreateResponse reservationCreateResponse = reservationPopupService.createReservation(userId, publicId, request);
//
//        verify(reservationRepository).save(captor.capture());
//        Reservation saved = captor.getValue();
//
//        //common
//        assertThat(reservationCreateResponse).isNotNull();
//        //Reservation
//        assertThat(saved.getPublicId()).isEqualTo(reservationCreateResponse.getReservationPublicId());
//        assertThat(saved.getHeadCount()).isEqualTo(2);
//        assertThat(saved.getRequest()).isEqualTo("내가 왕이다.");
//        assertThat(saved.getTotalPrice()).isEqualTo(2 * ship.getPrice());
//        assertThat(saved.getProcess()).isEqualTo(Reservation.Process.RESERVE_COMPLETED);
//        assertThat(saved.getUser()).isEqualTo(user);
//        assertThat(saved.getSchedule()).isEqualTo(schedule);
//        assertThat(saved.getCoupon()).isEqualTo(coupon);
//    }
//
//    @DisplayName("createReservation: BASIC 회원 정상 로직 - Schedule 검증")
//    @Test
//    void createReservation_BASIC_Schedule_검증() {
//        Long userId = 1L;
//        String publicId = "sch-001";
//
//        User user = User.create("김지오", "geo", User.Grade.BASIC, "01012341234");
//        Ship ship = Ship.create(20, "쭈갑", 90000, "주의사항 없음");
//
//        Schedule schedule = Schedule.create(
//                LocalDateTime.of(2025, 11, 5, 0, 0),
//                5,
//                3,
//                Status.WAITING,
//                Type.NORMAL,
//                ship
//        );
//        int beforeCurrentHeadCount = schedule.getCurrentHeadCount();
//
//        Coupon coupon = Coupon.create(Coupon.Type.WEEKDAY, user);
//
//        // repository mock stubbing
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//        when(scheduleRepository.findByPublicId(publicId)).thenReturn(Optional.of(schedule));
//        when(reservationRepository.save(any()))
//                .thenAnswer(invocation -> invocation.getArgument(0));
//
//        ReservationPopupRequest request = ReservationPopupRequest.builder()
//                .headCount(2)
//                .request("내가 왕이다.")
//                .couponId(coupon.getId())
//                .build();
//
//
//        ReservationCreateResponse reservationCreateResponse = reservationPopupService.createReservation(userId, publicId, request);
//
//        int afterCurrentHeadCount = schedule.getCurrentHeadCount();
//       //Schedule
//        assertThat(afterCurrentHeadCount).isEqualTo(beforeCurrentHeadCount - request.getHeadCount());
//    }
//
//    @DisplayName("createReservation: BASIC 회원 정상 로직 - Coupon 검증")
//    @Test
//    void createReservation_BASIC_Coupon_검증() {
//        Long userId = 1L;
//        String grade = "BASIC";
//        String publicId = "sch-001";
//
//        User user = User.create("김지오", "geo", User.Grade.BASIC, "01012341234");
//        Ship ship = Ship.create(20, "쭈갑", 90000, "주의사항 없음");
//
//        Schedule schedule = Schedule.create(
//                LocalDateTime.of(2025, 11, 5, 0, 0),
//                5,
//                3,
//                Status.WAITING,
//                Type.NORMAL,
//                ship
//        );
//
//        Coupon coupon = Coupon.create(Coupon.Type.WEEKDAY, user);
//        //coupon id 강제 세팅
//        ReflectionTestUtils.setField(coupon, "id", 1L);
//
//        ReservationPopupRequest request = ReservationPopupRequest.builder()
//                .headCount(2)
//                .request("내가 왕이다.")
//                .couponId(coupon.getId())
//                .build();
//
//        // repository mock stubbing
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//        when(scheduleRepository.findByPublicId(publicId)).thenReturn(Optional.of(schedule));
//        when(couponRepository.findById(coupon.getId())).thenReturn(Optional.of(coupon));
//        when(reservationRepository.save(any()))
//                .thenAnswer(invocation -> invocation.getArgument(0));
//
//        ReservationCreateResponse reservationCreateResponse = reservationPopupService.createReservation(userId, publicId, request);
//
//        //Coupon
//        assertThat(coupon.getUser()).isEqualTo(user);
//        assertThat(coupon.getStatus()).isEqualTo(Coupon.Status.USED);
//    }
//
//}