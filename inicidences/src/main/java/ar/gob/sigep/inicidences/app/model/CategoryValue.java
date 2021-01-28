package ar.gob.sigep.inicidences.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "VALORES_CAT")
public class CategoryValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idvalor")
	protected Integer id;
	
	@Column(name = "Descripcion")
	protected String description;
	
	@Column(name = "Categoria")
	protected String category;
	
	@Column(name = "Friendlycode")
	protected String friendlyCode;
	
	@Column(name = "Eliminado")
	protected Boolean deleted;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "Idpadre",
		referencedColumnName = "Idvalor"
	)
	protected CategoryValue father;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFriendlyCode() {
		return friendlyCode;
	}

	public void setFriendlyCode(String friendlyCode) {
		this.friendlyCode = friendlyCode;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public CategoryValue getFather() {
		return father;
	}

	public void setFather(CategoryValue father) {
		this.father = father;
	}

	@Override
	public String toString() {
		return "CategoryValue [id=" + id + ", description=" + description + ", category=" + category + ", friendlyCode="
				+ friendlyCode + ", deleted=" + deleted + ", father=" + father + "]";
	}

	
}
