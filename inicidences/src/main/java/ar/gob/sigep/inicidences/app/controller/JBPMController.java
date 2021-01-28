package ar.gob.sigep.inicidences.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.server.api.model.instance.TaskSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.gob.sigep.inicidences.bpm.service.BPMService;


@CrossOrigin(value = {"http://localhost:4200", "http://10.9.10.221:4200"} , maxAge = 3600)
@RestController()
public class JBPMController {
	
	@Autowired
	private BPMService service;
	

	@GetMapping("/actual")
	public String actual() {
		Map<String, Object> parameters = new HashMap<>();
		Long id = service.startNewInstance("Test-JBPM.Sample", parameters);
		
		return "Nuevo Instancia numero :::"+ id.toString() ;
	}
	
	@GetMapping("/businessTasks")
	public List<TaskSummary> getUserTasks() {
		Integer page = 0;
		Integer pageSize = 10;
		return service.getUserTasks(page, pageSize);
	} 

	@GetMapping("/variables/{piId}")
	public Map<String, Object> getVariables(@PathVariable(name = "piId") Long piId) {
		return service.getProcessVariables(piId);
	} 
	
	@GetMapping("/businessTasks/{taskId}/{key}/{object}")
	public String getUserTask(@PathVariable(value = "taskId") Long taskId, @PathVariable(value = "key") String key, @PathVariable(value = "object") String object) {
		Map<String, Object> params = new HashMap<>();
		params.put(key, object);
		service.doTask(taskId, params);
		return null;
	} 
		

}
