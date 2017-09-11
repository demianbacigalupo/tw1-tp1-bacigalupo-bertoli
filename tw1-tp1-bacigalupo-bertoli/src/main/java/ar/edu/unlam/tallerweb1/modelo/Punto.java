package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Punto {
	@Id
	private Long idPunto;
	private String latitud;
	private String longitud;
	
	@OneToMany(mappedBy="geoLocalizacion",cascade= CascadeType.ALL)
	private List <Farmacia> farmacias =  new ArrayList<Farmacia>();
	
	public Long getIdPunto() {
		return idPunto;
	}
	public void setIdPunto(Long idPunto) {
		this.idPunto = idPunto;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	
}
