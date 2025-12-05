package com.lamarfishing.core.ship.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QShip is a Querydsl query type for Ship
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShip extends EntityPathBase<Ship> {

    private static final long serialVersionUID = 985032451L;

    public static final QShip ship = new QShip("ship");

    public final StringPath fishType = createString("fishType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> maxHeadCount = createNumber("maxHeadCount", Integer.class);

    public final StringPath notification = createString("notification");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public QShip(String variable) {
        super(Ship.class, forVariable(variable));
    }

    public QShip(Path<? extends Ship> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShip(PathMetadata metadata) {
        super(Ship.class, metadata);
    }

}

