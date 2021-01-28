package ar.gob.sigep.inicidences.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import ar.gob.sigep.inicidences.app.model.QUser;
import ar.gob.sigep.inicidences.app.model.User;

public interface UserRepository
		extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

	@Override
	default void customize(final QuerydslBindings bindings, final QUser root) {
		bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::eq);
	}
}
