package ar.gob.sigep.inicidences.app.model.map;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Marker {

	protected Double lng;
	protected Double lat;
	@JsonIgnore
	protected String title = "Marker";
	
	public Marker(Coordinate c) {
		this.lng = c.x;
		this.lat = c.y;
	}
	
	public Marker(Point p) {
		this.lng = p.getCoordinate().x;
		this.lat = p.getCoordinate().y;
	}
	
	public Double getLng() {
		return lng;
	}
	
	public Double getLat() {
		return lat;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAsJSON() {
		return String.format("{ \"lng\": %f, \"lat\": %f }", lng, lat);
	}
}
