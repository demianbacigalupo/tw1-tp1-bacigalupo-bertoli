package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Barrio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBarrio;
	private String nombre;
	
	@OneToMany(mappedBy="barrio",cascade= CascadeType.ALL)
	private List <Direccion> direcciones = new ArrayList <Direccion>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idComuna")
	private Comuna comuna;
	
	public Barrio(String nombre) {
		this.nombre = nombre;
	}
	
	public Barrio() {
	}
	
	public Long getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(Long idBarrio) {
		this.idBarrio = idBarrio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
