package ar.gob.sigep.inicidences.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "workunits")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WorkUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Idworkunit")
	protected Integer id;
	
	@Column(name = "Iddominio")
	protected Integer domainId;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "Idvereda",
		referencedColumnName = "Idvereda"
	)
	protected SideWalk sideWalk;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "IDCalle", 
		referencedColumnName = "ID_Calle"
	)
	protected Street street;
	
	@Column(name = "Altura")
	protected Integer addressNumber;
	
	@JsonIgnore()
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "Idcreadopor", 
		referencedColumnName = "IdUsuario"
	)
	protected User creator;
	
	@Column(name = "Fechacreacion")
	protected String creationDate;
	
	@Column(name = "Fechaultimamod")
	protected String lastModificationDate;
	
	@Column(name = "Lat")
	protected Double lat;
	
	@Column(name = "Lng")	
	protected Double lng;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "documentos_workunit", 
		joinColumns = @JoinColumn(name = "Idworkunit"),
		inverseJoinColumns = @JoinColumn(name = "Iddoc")
	)
	protected List<Document> associatedDocuments;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getDomainId() {
		return domainId;
	}


	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}


	public SideWalk getSideWalk() {
		return sideWalk;
	}


	public void setSideWalk(SideWalk sideWalk) {
		this.sideWalk = sideWalk;
	}


	public Street getStreet() {
		return street;
	}


	public void setStreet(Street street) {
		this.street = street;
	}


	public Integer getAddressNumber() {
		return addressNumber;
	}


	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public String getLastModificationDate() {
		return lastModificationDate;
	}


	public void setLastModificationDate(String lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}


	public List<Document> getAssociatedDocuments() {
		return associatedDocuments;
	}


	public void setAssociatedDocuments(List<Document> associatedDocuments) {
		this.associatedDocuments = associatedDocuments;
	}


	@Override
	public String toString() {
		return "WorkUnit [id=" + id + ", domainId=" + domainId + ", sideWalk=" + sideWalk + ", street=" + street
				+ ", addressNumber=" + addressNumber + ", creator=" + creator + ", creationDate=" + creationDate
				+ ", lastModificationDate=" + lastModificationDate + ", associatedDocuments=" + associatedDocuments
				+ "]";
	}

	

}
