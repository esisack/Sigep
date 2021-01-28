package ar.gob.sigep.inicidences.bpm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.task.model.Status;
import org.kie.server.api.model.instance.ProcessInstance;
import org.kie.server.api.model.instance.TaskInstance;
import org.kie.server.api.model.instance.TaskSummary;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;
import org.kie.server.client.QueryServicesClient;
import org.kie.server.client.UIServicesClient;
import org.kie.server.client.UserTaskServicesClient;
import org.springframework.stereotype.Service;

@Service
public class BPMService {

	private String SERVER_URL = "http://localhost:8080/kie-server/services/rest/server";
	private String CONTAINER_ID = "oficios-bpm_1.0.0-SNAPSHOT";
	// private String SERVER_URL =
	// "http://10.9.10.3:8080/kie-server/services/rest/server";

	private UserTaskServicesClient taskService;
	private ProcessServicesClient processService;
	private UIServicesClient uiService;
	private String userName = "wsadmin";

	public BPMService() {

		KieServicesClient client = KieServicesFactory.newKieServicesRestClient(this.SERVER_URL, "wbadmin", "wbadmin");
		this.taskService = client.getServicesClient(UserTaskServicesClient.class);
		this.processService = client.getServicesClient(ProcessServicesClient.class);
		this.uiService = client.getServicesClient(UIServicesClient.class);

	}

	public Long startNewInstance(String processId, Map<String, Object> parameters) {
		return this.processService.startProcess(CONTAINER_ID, processId, parameters);
	}

	public ProcessInstance getProcessInstance(long pId) {
		return this.processService.getProcessInstance(CONTAINER_ID, pId, true);
	}

	public List<TaskSummary> getUserTasks(Integer page, Integer pageSize) {
		List<String> tasksStatus = new ArrayList<String>();
		tasksStatus.add(Status.Ready.toString()); // Asignado a grupo
		tasksStatus.add(Status.Reserved.toString()); // Asignada y no tomada
		tasksStatus.add(Status.InProgress.toString()); // Tomada por el usuario

		return this.taskService.findTasksAssignedAsPotentialOwner("wbadmin", tasksStatus, page, pageSize);
	}

	public TaskInstance getTask(long piid) {
		return this.taskService.getTaskInstance(CONTAINER_ID, piid);
	}

	public void doTask(String containerId, long taskId) {
		this.taskService.claimTask(containerId, taskId, "wbadmin");
		this.taskService.startTask(containerId, taskId, "wbadmin");
		this.taskService.completeTask(containerId, taskId, "wbadmin", null);
	}

	public void doTask(long taskId, Map<String, Object> params) {
		TaskInstance task = this.taskService.getTaskInstance(CONTAINER_ID, taskId, false, false, true);

		// Claim si aun no esta tomada por el usuario
		if (task.getActualOwner() == null) {
			this.taskService.claimTask(CONTAINER_ID, taskId, "wbadmin");
		}

		this.taskService.startTask(CONTAINER_ID, taskId, "wbadmin");
		this.taskService.completeTask(CONTAINER_ID, taskId, "wbadmin", params);

		this.getProcessInstance(1L).getVariables();
	}

	public Map<String, Object> getProcessVariables(long piid) {
		return this.processService.getProcessInstanceVariables(CONTAINER_ID, piid);
	}

	public String getProcessInstanceImage(Long processInstanceId) {
		return this.uiService.getProcessInstanceImage(CONTAINER_ID, processInstanceId);
	}

	public UserTaskServicesClient getTaskService() {
		return taskService;
	}

	public void setTaskService(UserTaskServicesClient taskService) {
		this.taskService = taskService;
	}

	public ProcessServicesClient getProcessService() {
		return processService;
	}

	public void setProcessService(ProcessServicesClient processService) {
		this.processService = processService;
	}

	public UIServicesClient getUiService() {
		return uiService;
	}

	public void setUiService(UIServicesClient uiService) {
		this.uiService = uiService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Object> getProcessVariables(String containerId, long piid) {
		return this.processService.getProcessInstanceVariables(containerId, piid);
	}

	public TaskInstance getTask(String containerId, long piid) {
		return this.taskService.getTaskInstance(containerId, piid);
	}

	public String getProcessInstanceImage(String containerId, Long processInstanceId) {
		return this.uiService.getProcessInstanceImage(containerId, processInstanceId);
	}

	public UIServicesClient getServicesClient() {
		return this.uiService;
	}

	public void principal() throws Exception {
		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(SERVER_URL, "wbadmin", "wbadmin");
		KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
		ProcessServicesClient processServices = client.getServicesClient(ProcessServicesClient.class);
		UserTaskServicesClient taskServices = client.getServicesClient(UserTaskServicesClient.class);

		// start a new process instance
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("employee", "krisv");
		// params.put("reason", "Yearly performance evaluation");
		Long processInstanceId = processServices.startProcess(CONTAINER_ID, "Test-JBPM.Sample", params);
		System.out.println("Start Evaluation process " + processInstanceId);

		// complete Self Evaluation
		List<TaskSummary> tasks = taskServices.findTasksAssignedAsPotentialOwner("wbadmin", 0, 10);
		TaskSummary task = findTask(tasks, processInstanceId);
		System.out.println("'krisv' completing task " + task.getName() + ": " + task.getDescription());
		taskServices.startTask(CONTAINER_ID, task.getId(), "krisv");
		Map<String, Object> results = new HashMap<String, Object>();
		results.put("performance", "10");
		taskServices.completeTask(CONTAINER_ID, task.getId(), "krisv", results);

		// john from HR
		config = KieServicesFactory.newRestConfiguration(SERVER_URL, "wbadmin", "wbadmin");
		client = KieServicesFactory.newKieServicesClient(config);
		taskServices = client.getServicesClient(UserTaskServicesClient.class);

		tasks = taskServices.findTasksAssignedAsPotentialOwner("wbadmin", 0, 10);
		task = findTask(tasks, processInstanceId);
		System.out.println("'john' completing task " + task.getName() + ": " + task.getDescription());
		taskServices.claimTask(CONTAINER_ID, task.getId(), "wbadmin");
		taskServices.startTask(CONTAINER_ID, task.getId(), "wadmin");
		results = new HashMap<String, Object>();
		results.put("performance", "9");
		taskServices.completeTask(CONTAINER_ID, task.getId(), "john", results);

		// mary from PM
		config = KieServicesFactory.newRestConfiguration(SERVER_URL, "wbadmin", "wbadmin");
		client = KieServicesFactory.newKieServicesClient(config);
		taskServices = client.getServicesClient(UserTaskServicesClient.class);

		tasks = taskServices.findTasksAssignedAsPotentialOwner("wbadmin", 0, 10);
		task = findTask(tasks, processInstanceId);
		System.out.println("'mary' completing task " + task.getName() + ": " + task.getDescription());
		taskServices.claimTask(CONTAINER_ID, task.getId(), "wbadmin");
		taskServices.startTask(CONTAINER_ID, task.getId(), "wbadmin");
		results = new HashMap<String, Object>();
		results.put("performance", "10");
		taskServices.completeTask(CONTAINER_ID, task.getId(), "wbadmin", results);

		QueryServicesClient queryServices = client.getServicesClient(QueryServicesClient.class);
		ProcessInstance processInstance = queryServices.findProcessInstanceById(processInstanceId);
		if (processInstance.getState() != 2) {
			throw new RuntimeException("Process instance not completed");
		}
		System.out.println("Process instance completed");
	}

	private static TaskSummary findTask(List<TaskSummary> tasks, long processInstanceId) {
		for (TaskSummary task : tasks) {
			if (task.getProcessInstanceId() == processInstanceId) {
				return task;
			}
		}
		throw new RuntimeException("Could not find task for process instance " + processInstanceId + " [" + tasks.size()
				+ " task(s) in total]");
	}
}
