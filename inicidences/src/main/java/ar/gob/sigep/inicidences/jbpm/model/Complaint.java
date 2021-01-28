package ar.gob.sigep.inicidences.jbpm.model;

import java.util.Map;

import org.kie.server.api.model.instance.TaskSummary;


public class Complaint extends BusinessTask {
	private static final String PROC_VAR_STREET_ID = "Calle";
	private static final String PROC_VAR_ADDRESS_NUMBER = "Altura";
	private static final String PROC_VAR_COMMUNE = "Comuna";
	private static final String PROC_VAR_STREET_WALK_ID = "CV";
	private static final String PROC_VAR_STREET_WALK_WKT = "WKT";
	private static final String PROC_VAR_STREET_WALK_STATUS = "Estado";
	private static final String PROC_VAR_STREET_WALK_AREA = "Area";
	private static final String PROC_VAR_PRIORITY_COMPLAINT = "Prioritario";
	
	protected Integer streetId;
	protected Integer addressNumber;
	protected String streetWalkKey;
	protected Integer commune;
	protected String streetWalkWkt;
	protected String streetWalkStatus;
	protected Double streetWalkArea;
	protected Boolean priorityComplaint;
	
	public Complaint(TaskSummary task) {
		super(task);				
	}
	
	public Complaint(TaskSummary task, Map<String, Object> variables) {
		super(task);
		
	}
	
	public Integer getStreetId() {
		return this.streetId;
	}
	
	public Integer getAddressNumber() {
		return this.addressNumber;
	}
	
	public String getStreetWalkKey() {
		return this.streetWalkKey;
	}
	
	public void setStreetWalkKey(String key) {
		this.streetWalkKey = key;
	}
	
	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}
	
	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}

	public Integer getCommune() {
		return this.commune;
	}

	public void setCommune(Integer commune) {
		this.commune = commune;
	}

	public String getStreetWalkWkt() {
		return this.streetWalkWkt;
	}

	public void setStreetWalkWkt(String streetWalkWkt) {
		this.streetWalkWkt = streetWalkWkt;
	}

	public String getstreetWalkStatus() {
		return this.streetWalkStatus;
	}

	public void setstreetWalkStatus(String status) {
		this.streetWalkStatus = status;
	}

	public Double getStreetWalkArea() {
		return this.streetWalkArea;
	}

	public void setStreetWalkArea(Double area) {
		this.streetWalkArea = area;
	}

	public Boolean getPriorityComplaint() {
		return this.priorityComplaint;
	}

	public void setPriorityComplaint(Boolean priorityComplaint) {
		this.priorityComplaint = priorityComplaint;
	}
}
