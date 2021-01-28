package ar.gob.sigep.inicidences.app.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWorkUnit is a Querydsl query type for WorkUnit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkUnit extends EntityPathBase<WorkUnit> {

    private static final long serialVersionUID = -1132807446L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWorkUnit workUnit = new QWorkUnit("workUnit");

    public final NumberPath<Integer> addressNumber = createNumber("addressNumber", Integer.class);

    public final ListPath<Document, QDocument> associatedDocuments = this.<Document, QDocument>createList("associatedDocuments", Document.class, QDocument.class, PathInits.DIRECT2);

    public final StringPath creationDate = createString("creationDate");

    public final QUser creator;

    public final NumberPath<Integer> domainId = createNumber("domainId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastModificationDate = createString("lastModificationDate");

    public final QSideWalk sideWalk;

    public final QStreet street;

    public QWorkUnit(String variable) {
        this(WorkUnit.class, forVariable(variable), INITS);
    }

    public QWorkUnit(Path<? extends WorkUnit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWorkUnit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWorkUnit(PathMetadata metadata, PathInits inits) {
        this(WorkUnit.class, metadata, inits);
    }

    public QWorkUnit(Class<? extends WorkUnit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creator = inits.isInitialized("creator") ? new QUser(forProperty("creator")) : null;
        this.sideWalk = inits.isInitialized("sideWalk") ? new QSideWalk(forProperty("sideWalk")) : null;
        this.street = inits.isInitialized("street") ? new QStreet(forProperty("street")) : null;
    }

}

