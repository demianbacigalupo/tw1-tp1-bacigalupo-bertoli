package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Direccion {
	@Id
	private Long id;
	private String calle;
	private String numero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idBarrio")
	private Barrio barrio;
	
	public Direccion(String calle, String numero, Barrio barrio) {
		this.calle = calle;
		this.numero = numero;
		this.barrio = barrio;
	}
	public Barrio getBarrio() {
		return barrio;
	}
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
