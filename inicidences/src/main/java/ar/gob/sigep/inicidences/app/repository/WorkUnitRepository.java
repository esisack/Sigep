package ar.gob.sigep.inicidences.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import ar.gob.sigep.inicidences.app.model.QWorkUnit;
import ar.gob.sigep.inicidences.app.model.WorkUnit;

@Repository
public interface WorkUnitRepository extends JpaRepository<WorkUnit, Integer>, QuerydslPredicateExecutor<WorkUnit>,
		QuerydslBinderCustomizer<QWorkUnit> {

	@Override
	default void customize(final QuerydslBindings bindings, final QWorkUnit root) {
		bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::eq);
	}
}
