package ar.gob.sigep.inicidences.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

import ar.gob.sigep.inicidences.app.model.Incidence;

public class IncidencePredicate {
	 
    private SearchCriteria criteria;
 
    public IncidencePredicate(SearchCriteria param) {
		this.criteria = param;
	}

	public BooleanExpression getPredicate() {
        PathBuilder<Incidence> entityPath = new PathBuilder<>(Incidence.class, "incidence");
 
        if (isNumeric(criteria.getValue().toString())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getValue().toString());
            switch (criteria.getOperation()) {
                case ":":
                    return path.eq(value);
                case ">":
                    return path.goe(value);
                case "<":
                    return path.loe(value);
            }
        } 
        else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteria.getValue().toString());
            }
        }
        return null;
    }
}