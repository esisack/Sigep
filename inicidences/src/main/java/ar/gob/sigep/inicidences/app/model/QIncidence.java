package ar.gob.sigep.inicidences.app.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIncidence is a Querydsl query type for Incidence
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIncidence extends EntityPathBase<Incidence> {

    private static final long serialVersionUID = 858100655L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIncidence incidence = new QIncidence("incidence");

    public final QWorkUnit _super;

    //inherited
    public final NumberPath<Integer> addressNumber;

    public final QCategoryValue area;

    //inherited
    public final ListPath<Document, QDocument> associatedDocuments;

    //inherited
    public final StringPath creationDate;

    // inherited
    public final QUser creator;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Integer> domainId;

    //inherited
    public final NumberPath<Integer> id;

    //inherited
    public final StringPath lastModificationDate;

    // inherited
    public final QSideWalk sideWalk;

    public final QCategoryValue source;

    // inherited
    public final QStreet street;

    public final QCategoryValue type;

    public QIncidence(String variable) {
        this(Incidence.class, forVariable(variable), INITS);
    }

    public QIncidence(Path<? extends Incidence> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIncidence(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIncidence(PathMetadata metadata, PathInits inits) {
        this(Incidence.class, metadata, inits);
    }

    public QIncidence(Class<? extends Incidence> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QWorkUnit(type, metadata, inits);
        this.addressNumber = _super.addressNumber;
        this.area = inits.isInitialized("area") ? new QCategoryValue(forProperty("area"), inits.get("area")) : null;
        this.associatedDocuments = _super.associatedDocuments;
        this.creationDate = _super.creationDate;
        this.creator = _super.creator;
        this.domainId = _super.domainId;
        this.id = _super.id;
        this.lastModificationDate = _super.lastModificationDate;
        this.sideWalk = _super.sideWalk;
        this.source = inits.isInitialized("source") ? new QCategoryValue(forProperty("source"), inits.get("source")) : null;
        this.street = _super.street;
        this.type = inits.isInitialized("type") ? new QCategoryValue(forProperty("type"), inits.get("type")) : null;
    }

}

