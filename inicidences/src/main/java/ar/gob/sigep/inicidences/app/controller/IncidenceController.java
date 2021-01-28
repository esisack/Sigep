package ar.gob.sigep.inicidences.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import ar.gob.sigep.inicidences.app.model.Incidence;
import ar.gob.sigep.inicidences.app.repository.IncidenceRepository;




@CrossOrigin(value = {"http://localhost:4200", "http://10.9.10.217:4200"} , maxAge = 3600)
@RestController
public class IncidenceController {
	
	@Autowired
	private IncidenceRepository repository;
	
	@GetMapping("/incidents")
	public List<Incidence> getAllIncidences() {
		Pageable pageable = PageRequest.of(1, 12);
		return (List<Incidence>) repository.findAll(pageable).toList();
	}
	
	@GetMapping("/incidents/{id}")
	public Optional<Incidence> getIncidenceById(@PathVariable(value = "id") Integer id) {
		return repository.findById(id);
	}

    @GetMapping(value = "/incidents/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Incidence> queryOverUser(@QuerydslPredicate(root = Incidence.class) Predicate predicate) {
        final BooleanBuilder builder = new BooleanBuilder();
        return repository.findAll(builder.and(predicate));
    }
}
