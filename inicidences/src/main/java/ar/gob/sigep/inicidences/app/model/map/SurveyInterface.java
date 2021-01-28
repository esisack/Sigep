package ar.gob.sigep.inicidences.app.model.map;

import java.util.List;


public interface SurveyInterface {
	
	public boolean hasImages();
	
	public Marker getLocation();
	
	public List<Image> getImages();
	

}