package com.lamarfishing.core.log.statistic.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStatistic is a Querydsl query type for Statistic
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStatistic extends EntityPathBase<Statistic> {

    private static final long serialVersionUID = 1682250365L;

    public static final QStatistic statistic = new QStatistic("statistic");

    public final NumberPath<Integer> dailyDeposited = createNumber("dailyDeposited", Integer.class);

    public final NumberPath<Integer> dailyReserved = createNumber("dailyReserved", Integer.class);

    public final NumberPath<Integer> dailySales = createNumber("dailySales", Integer.class);

    public final NumberPath<Integer> dailyVisited = createNumber("dailyVisited", Integer.class);

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Integer> deposit24Hour = createNumber("deposit24Hour", Integer.class);

    public final NumberPath<Integer> depositExpired = createNumber("depositExpired", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QStatistic(String variable) {
        super(Statistic.class, forVariable(variable));
    }

    public QStatistic(Path<? extends Statistic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStatistic(PathMetadata metadata) {
        super(Statistic.class, metadata);
    }

}

