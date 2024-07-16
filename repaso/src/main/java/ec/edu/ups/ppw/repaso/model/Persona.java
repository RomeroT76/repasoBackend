package ec.edu.ups.ppw.repaso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_Personas")
public class Persona {
	
	@Id
	@Column(name = "per_cedula")
	private String cedula;
	
	@Column(name = "per_nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "fk_persona_ciudad")
	private Ciudad ciudad;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}
