package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFarmacia;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name =  "idPunto")
	private Punto geoLocalizacion;
	

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name =  "idDireccion")
	private Direccion direccion;
	
	
	public Farmacia(String nombre, String telefono, String diaDeTurno) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.diaDeTurno = diaDeTurno;
	}

	public Farmacia() {
		
	}

	public Long getIdFarmacia() {
		return idFarmacia;
	}

	public void setIdFarmacia(Long idFarmacia) {
		this.idFarmacia = idFarmacia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDiaDeTurno() {
		return diaDeTurno;
	}

	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}

	public Punto getGeoLocalizacion() {
		return geoLocalizacion;
	}

	public void setGeoLocalizacion(Punto geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}
