package ar.gob.sigep.inicidences.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "usuarios")
public class User {
	@Id
	@Column(name = "idusuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nombre", nullable = false)
	private String name;
	
	@Column(name= "Email", nullable = false)
	private String email;
	
	@Column(name = "LDAP_ID")
	private String adAlias;

	public User() {
		
	}
	
	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getADAlias() {
		return adAlias;
	}

	public void setADAlias(String adAlias) {
		this.adAlias = adAlias;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", adAlias=" + adAlias + "]";
	}

	
}
