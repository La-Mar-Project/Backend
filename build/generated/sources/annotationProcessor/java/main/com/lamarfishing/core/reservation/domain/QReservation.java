package com.lamarfishing.core.reservation.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = -1544321261L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservation reservation = new QReservation("reservation");

    public final com.lamarfishing.core.coupon.domain.QCoupon coupon;

    public final NumberPath<Integer> headCount = createNumber("headCount", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Reservation.Process> process = createEnum("process", Reservation.Process.class);

    public final StringPath publicId = createString("publicId");

    public final StringPath request = createString("request");

    public final com.lamarfishing.core.schedule.domain.QSchedule schedule;

    public final NumberPath<Integer> totalPrice = createNumber("totalPrice", Integer.class);

    public final com.lamarfishing.core.user.domain.QUser user;

    public QReservation(String variable) {
        this(Reservation.class, forVariable(variable), INITS);
    }

    public QReservation(Path<? extends Reservation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservation(PathMetadata metadata, PathInits inits) {
        this(Reservation.class, metadata, inits);
    }

    public QReservation(Class<? extends Reservation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coupon = inits.isInitialized("coupon") ? new com.lamarfishing.core.coupon.domain.QCoupon(forProperty("coupon"), inits.get("coupon")) : null;
        this.schedule = inits.isInitialized("schedule") ? new com.lamarfishing.core.schedule.domain.QSchedule(forProperty("schedule"), inits.get("schedule")) : null;
        this.user = inits.isInitialized("user") ? new com.lamarfishing.core.user.domain.QUser(forProperty("user")) : null;
    }

}

