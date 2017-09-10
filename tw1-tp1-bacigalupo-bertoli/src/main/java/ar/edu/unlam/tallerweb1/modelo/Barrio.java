package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Barrio {
	@Id
	private Long id;
	private String nombre;
	
	@OneToMany (mappedBy="barrio", cascade=CascadeType.ALL)
	ArrayList <Direccion> direccion = new ArrayList <Direccion>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idComuna")
	private Comuna comuna;
	
	public Barrio(String nombre) {
		this.nombre = nombre;
	}
	
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
	
	
}
