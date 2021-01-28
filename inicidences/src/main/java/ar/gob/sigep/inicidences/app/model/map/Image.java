package ar.gob.sigep.inicidences.app.model.map;

public class Image {

	protected Integer id;
	protected String title;
	protected String details;
	protected String fullPath;

	public Image(Integer id, String title, String details, String fullPath) {
		this.id = id;
		this.title = title;
		this.details = details;
		this.fullPath = fullPath;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDetails() {
		return details;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	
	
}
