package com.lamarfishing.core.log.message.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMessageLog is a Querydsl query type for MessageLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessageLog extends EntityPathBase<MessageLog> {

    private static final long serialVersionUID = 924228327L;

    public static final QMessageLog messageLog = new QMessageLog("messageLog");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath recipientPhone = createString("recipientPhone");

    public final EnumPath<Result> result = createEnum("result", Result.class);

    public final DateTimePath<java.time.LocalDateTime> timeStamp = createDateTime("timeStamp", java.time.LocalDateTime.class);

    public QMessageLog(String variable) {
        super(MessageLog.class, forVariable(variable));
    }

    public QMessageLog(Path<? extends MessageLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMessageLog(PathMetadata metadata) {
        super(MessageLog.class, metadata);
    }

}

