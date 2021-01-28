package ar.gob.sigep.inicidences.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import ar.gob.sigep.inicidences.app.model.Street;
import ar.gob.sigep.inicidences.app.repository.StreetRepository;


@CrossOrigin(value = {"http://localhost:4200", "http://10.9.10.217:4200"} , maxAge = 3600)
@RestController
public class StreetController {
	
	@Autowired
	private StreetRepository repository;
	
	@GetMapping("/streets")
	public List<Street> getAllIncidences() {
		return repository.findAll();
	}
	
	@GetMapping("/streets/{id}")
	public Optional<Street> getIncidenceById(@PathVariable(value = "id") Integer id) {
		return repository.findById(id);
	}
	
    @GetMapping(value = "/streets/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Street> queryOverUser(@QuerydslPredicate(root = Street.class) Predicate predicate) {
        final BooleanBuilder builder = new BooleanBuilder();
        return repository.findAll(builder.and(predicate));
    }

}
