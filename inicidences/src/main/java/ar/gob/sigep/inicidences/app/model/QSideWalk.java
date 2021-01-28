package ar.gob.sigep.inicidences.app.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSideWalk is a Querydsl query type for SideWalk
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSideWalk extends EntityPathBase<SideWalk> {

    private static final long serialVersionUID = -950471051L;

    public static final QSideWalk sideWalk = new QSideWalk("sideWalk");

    public final StringPath code = createString("code");

    public final NumberPath<Integer> commune = createNumber("commune", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QSideWalk(String variable) {
        super(SideWalk.class, forVariable(variable));
    }

    public QSideWalk(Path<? extends SideWalk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSideWalk(PathMetadata metadata) {
        super(SideWalk.class, metadata);
    }

}

