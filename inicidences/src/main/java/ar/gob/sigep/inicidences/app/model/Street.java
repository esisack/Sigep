package ar.gob.sigep.inicidences.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CALLES")
public class Street {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Calle")
	protected Integer id;
	
	@Column(name = "Nombre")
	protected String name;
	
	@Column(name = "Codigocalleusig")
	protected Integer usigId;
	
	public Street() {
		
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getUsigId() {
		return usigId;
	}

	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + ", usigId=" + usigId + "]";
	}

	
}
