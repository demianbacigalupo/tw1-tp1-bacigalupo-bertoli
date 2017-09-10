package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comuna {
	
	@Id
	private Long id;
	private String nombre;
	
	@OneToMany (mappedBy="comuna", cascade=CascadeType.ALL)
	ArrayList <Barrio> barrio = new ArrayList<Barrio>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Barrio> getBarrio() {
		return barrio;
	}

	public void setBarrio(ArrayList<Barrio> barrio) {
		this.barrio = barrio;
	}
}
