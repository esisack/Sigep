package ar.gob.sigep.inicidences.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Iddoc")
	protected Integer id;
	
	@Column(name = "Extension")
	protected String extension;
	
	@Column(name = "Fechatoma")
	protected String date;
	
	public Document() {
	}

	public Integer getId() {
		return id;
	}

	public String getExtension() {
		return extension;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", extension=" + extension + ", date=" + date + "]";
	}

	
}
