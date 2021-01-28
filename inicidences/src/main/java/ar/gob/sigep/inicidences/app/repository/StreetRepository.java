package ar.gob.sigep.inicidences.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import ar.gob.sigep.inicidences.app.model.QStreet;
import ar.gob.sigep.inicidences.app.model.Street;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer>, QuerydslPredicateExecutor<Street>,
		QuerydslBinderCustomizer<QStreet> {

	@Override
	default void customize(final QuerydslBindings bindings, final QStreet root) {
		bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::eq);
	}
}
