package com.lamarfishing.core.log.admin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminLog is a Querydsl query type for AdminLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminLog extends EntityPathBase<AdminLog> {

    private static final long serialVersionUID = 807722535L;

    public static final QAdminLog adminLog = new QAdminLog("adminLog");

    public final StringPath account = createString("account");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ip = createString("ip");

    public final DateTimePath<java.time.LocalDateTime> timeStamp = createDateTime("timeStamp", java.time.LocalDateTime.class);

    public QAdminLog(String variable) {
        super(AdminLog.class, forVariable(variable));
    }

    public QAdminLog(Path<? extends AdminLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminLog(PathMetadata metadata) {
        super(AdminLog.class, metadata);
    }

}

