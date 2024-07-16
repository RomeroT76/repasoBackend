package ec.edu.ups.ppw.repaso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_Ciudades")
public class Ciudad {
	
	@Id
	@Column(name = "Codigo")
	private int id;
	
	@Column(name = "Nombre")
	private String nombre;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
