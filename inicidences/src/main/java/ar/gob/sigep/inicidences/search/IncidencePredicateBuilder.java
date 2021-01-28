package ar.gob.sigep.inicidences.search;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

public class IncidencePredicateBuilder {
    private List<SearchCriteria> params;
 
    public IncidencePredicateBuilder() {
        params = new ArrayList<>();
    }
 
    public IncidencePredicateBuilder with(
      String key, String operation, Object value) {
   
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<BooleanExpression> predicates = new ArrayList<>();
        IncidencePredicate predicate;
        for (SearchCriteria param : params) {
            predicate = new IncidencePredicate(param);
            BooleanExpression exp = predicate.getPredicate();
            if (exp != null) {
                predicates.add(exp);
            }
        }
 
        BooleanExpression result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }
        return result;
    }
    
   static class BooleanExpressionWrapper {
        
        private BooleanExpression result;

        public BooleanExpressionWrapper(final BooleanExpression result) {
            super();
            this.result = result;
        }

        public BooleanExpression getResult() {
            return result;
        }
        public void setResult(BooleanExpression result) {
            this.result = result;
        }
    }
}
