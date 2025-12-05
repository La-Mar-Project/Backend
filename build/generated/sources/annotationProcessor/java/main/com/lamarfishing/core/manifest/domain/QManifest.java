package com.lamarfishing.core.manifest.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QManifest is a Querydsl query type for Manifest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QManifest extends EntityPathBase<Manifest> {

    private static final long serialVersionUID = -33423895L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QManifest manifest = new QManifest("manifest");

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    public final StringPath emergencyContact = createString("emergencyContact");

    public final DateTimePath<java.time.LocalDateTime> expiresAt = createDateTime("expiresAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath phone = createString("phone");

    public final com.lamarfishing.core.schedule.domain.QSchedule schedule;

    public final EnumPath<Manifest.Sex> sex = createEnum("sex", Manifest.Sex.class);

    public final StringPath username = createString("username");

    public QManifest(String variable) {
        this(Manifest.class, forVariable(variable), INITS);
    }

    public QManifest(Path<? extends Manifest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QManifest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QManifest(PathMetadata metadata, PathInits inits) {
        this(Manifest.class, metadata, inits);
    }

    public QManifest(Class<? extends Manifest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.schedule = inits.isInitialized("schedule") ? new com.lamarfishing.core.schedule.domain.QSchedule(forProperty("schedule"), inits.get("schedule")) : null;
    }

}

