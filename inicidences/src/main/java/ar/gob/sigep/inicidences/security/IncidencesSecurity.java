package ar.gob.sigep.inicidences.security;

import java.util.Date;

public class IncidencesSecurity {

	private String tocken;
	private Date expiration;
	
	
	public String getTocken() {
		return tocken;
	}
	public void setTocken(String tocken) {
		this.tocken = tocken;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	
}
