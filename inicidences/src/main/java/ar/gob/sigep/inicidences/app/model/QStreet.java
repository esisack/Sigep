package ar.gob.sigep.inicidences.app.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStreet is a Querydsl query type for Street
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStreet extends EntityPathBase<Street> {

    private static final long serialVersionUID = 1877741560L;

    public static final QStreet street = new QStreet("street");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> usigId = createNumber("usigId", Integer.class);

    public QStreet(String variable) {
        super(Street.class, forVariable(variable));
    }

    public QStreet(Path<? extends Street> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStreet(PathMetadata metadata) {
        super(Street.class, metadata);
    }

}

