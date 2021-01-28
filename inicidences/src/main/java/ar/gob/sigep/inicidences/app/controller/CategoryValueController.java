package ar.gob.sigep.inicidences.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import ar.gob.sigep.inicidences.app.model.CategoryValue;
import ar.gob.sigep.inicidences.app.repository.CategoryValueRepository;



@CrossOrigin(value = {"http://localhost:4200", "http://10.9.10.217:4200"} , maxAge = 3600)
@RestController
public class CategoryValueController {
	
	@Autowired
	private CategoryValueRepository repository;
	
	@GetMapping("/categoryValues")
	public List<CategoryValue> getAllCategoryValues() {
		return repository.findAll();
	}
	
	@GetMapping("/categoryValues/{id}")
	public List<CategoryValue> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("/categoryValues/category/{category}")
	public List<CategoryValue> getValuesByCategory(@PathVariable(value = "category") String category) {
		return repository.findByCategory(category);
	}
	

    @GetMapping(value = "/categories/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CategoryValue> queryOverUser(@QuerydslPredicate(root = CategoryValue.class) Predicate predicate) {
        final BooleanBuilder builder = new BooleanBuilder();
        return repository.findAll(builder.and(predicate));
    }
}
