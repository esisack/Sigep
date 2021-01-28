package ar.gob.sigep.inicidences.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ar.gob.sigep.inicidences.app.model.map.Image;
import ar.gob.sigep.inicidences.app.model.map.Marker;

@Entity
@Table(name = "incidencias")
@DiscriminatorValue("DBIncidencia")
@PrimaryKeyJoinColumn(name = "idincidencia")
public class Incidence extends WorkUnit implements SurveyInterface {

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Tipo", referencedColumnName = "Idvalor")
	private CategoryValue type;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Subtipo", referencedColumnName = "Idvalor")
	private CategoryValue subType;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Origen", referencedColumnName = "Idvalor")
	private CategoryValue source;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Idarea", referencedColumnName = "Idvalor")
	private CategoryValue area;

	@Column(table = "incidencias", name = "Descripcion")
	private String description;

	public Incidence() {

	}

	public CategoryValue getType() {
		return type;
	}

	public CategoryValue getSource() {
		return source;
	}

	public CategoryValue getArea() {
		return area;
	}

	public void setType(CategoryValue type) {
		this.type = type;
	}

	public CategoryValue getSubType() {
		return subType;
	}

	public void setSubType(CategoryValue subType) {
		this.subType = subType;
	}

	public void setSource(CategoryValue source) {
		this.source = source;
	}

	public void setArea(CategoryValue area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Marker getLocation() {
		if (this.sideWalk == null) {
			return null;
		}

//		return new Marker(this.sideWalk.getCentroid());
		return null;
	}

	public boolean hasImages() {
		return true;
	}

	public List<Image> getImages() {
		if (this.associatedDocuments != null) {
			List<Image> images = new ArrayList<>();
			for (Document doc : this.associatedDocuments) {
				String full = getDocumentFullPath(doc);
				images.add(new Image(doc.getId(), "Imagen de relevamiento",
						String.format("Tomada el %s", doc.getDate()), full));
			}

			return images;
		}

		return null;
	}

	@Override
	public String toString() {
		return "Incidence [type=" + type + ", source=" + source + ", area=" + area + ", description=" + description
				+ "]";
	}

	private String getDocumentFullPath(Document doc) {
		String[] prePath = String.valueOf(doc.getId()).split("", 6);
		String[] path = new String[5];

		if (prePath.length > 5) {
			for (int i = 0; i < 5; i++) {
				path[i] = prePath[i];
			}

		} else {
			path = prePath;
		}

		return String.format("%s/%d", String.join("/", path), doc.getId());
	}

}