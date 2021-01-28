package ar.gob.sigep.inicidences.app.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoryValue is a Querydsl query type for CategoryValue
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategoryValue extends EntityPathBase<CategoryValue> {

    private static final long serialVersionUID = 349152638L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategoryValue categoryValue = new QCategoryValue("categoryValue");

    public final StringPath category = createString("category");

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath description = createString("description");

    public final QCategoryValue father;

    public final StringPath friendlyCode = createString("friendlyCode");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QCategoryValue(String variable) {
        this(CategoryValue.class, forVariable(variable), INITS);
    }

    public QCategoryValue(Path<? extends CategoryValue> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategoryValue(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategoryValue(PathMetadata metadata, PathInits inits) {
        this(CategoryValue.class, metadata, inits);
    }

    public QCategoryValue(Class<? extends CategoryValue> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.father = inits.isInitialized("father") ? new QCategoryValue(forProperty("father"), inits.get("father")) : null;
    }

}

