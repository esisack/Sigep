package ar.gob.sigep.inicidences.app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "VEREDAS")
public class SideWalk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idvereda")
	protected Integer id;

	@Column(name = "Codvereda")
	protected String code;

	@Column(name = "Comuna")
	protected Integer commune;

	@JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(contentUsing = GeometryDeserializer.class)
	@Column(name = "Centroide")
	private Point centroid;

	@JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(contentUsing = GeometryDeserializer.class)
	@Column(name = "Geodato")
	private Polygon polygon;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCommune() {
		return commune;
	}

	public void setCommune(Integer commune) {
		this.commune = commune;
	}

	
	
	public Point getCentroid() {
		return centroid;
	}

	public void setCentroid(Point centroid) {
		this.centroid = centroid;
	}

	public Polygon getPolygon() {
		return polygon;
	}

	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}

	@Override
	public String toString() {
		return "SideWalk [id=" + id + ", code=" + code + ", commune=" + commune + "]";
	}

}
