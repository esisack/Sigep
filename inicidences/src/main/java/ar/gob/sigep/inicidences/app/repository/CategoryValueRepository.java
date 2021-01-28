package ar.gob.sigep.inicidences.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import ar.gob.sigep.inicidences.app.model.CategoryValue;
import ar.gob.sigep.inicidences.app.model.QCategoryValue;


@Repository
public interface CategoryValueRepository extends JpaRepository<CategoryValue, Integer>, 
QuerydslPredicateExecutor<CategoryValue>, 
QuerydslBinderCustomizer<QCategoryValue>  {
  
@Override
default void customize(final QuerydslBindings bindings, final QCategoryValue root) {
    bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::eq);
}
	List<CategoryValue> findByCategory(String category);

}
