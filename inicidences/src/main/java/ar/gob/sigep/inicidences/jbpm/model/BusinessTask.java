package ar.gob.sigep.inicidences.jbpm.model;

import java.util.Date;
import java.util.Map;

import org.kie.api.task.model.Status;
import org.kie.server.api.model.instance.TaskSummary;

/*
 * Tarea del jBPM
 */
public abstract class BusinessTask {
	protected Long id;
	protected Long parentId;
	protected String description;
	protected Status status;
	protected Integer priority;
	protected String actualOwner;
	protected Boolean skipable;
	protected Date createdOn;
	protected Date activationTime;
	protected String containerId;
	protected String processId;
	protected Map<String, Object> processVariables;
	
	public BusinessTask(TaskSummary task) {
		this.id = task.getId();
		this.parentId = task.getParentId();
		this.description = task.getDescription() == null || task.getDescription().equals("") ? "Tarea sin descripcion" : task.getDescription();
		this.status = Status.valueOf(task.getStatus());
		this.priority = task.getPriority();
		this.actualOwner = task.getActualOwner();
		this.skipable = task.getSkipable();
		this.createdOn = task.getCreatedOn();
		this.activationTime = task.getActivationTime();
		this.containerId = task.getContainerId();
		this.processId = task.getProcessId();
		
	}
	
	public BusinessTask(TaskSummary task, Map<String, Object> variables) {
		this(task);
		this.processVariables = variables;
	}
}
