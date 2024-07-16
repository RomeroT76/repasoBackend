package ec.edu.ups.ppw.repaso.bussines;

import java.util.List;

import ec.edu.ups.ppw.repaso.dao.PersonaDAO;
import ec.edu.ups.ppw.repaso.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionPersonas {
	
	@Inject
	private PersonaDAO daoP;
	
	public Persona obtenerPersona(String cedula) {
		Persona persona = this.daoP.leer(cedula);
		return persona;
	}
	
	public List<Persona> obtenerPersonas() {
		return this.daoP.obtenerTodo();
	}
	
	public void insertarPersona(Persona persona) {
		this.daoP.insertar(persona);
	}
	
	public void borrarPersona(String cedula) {
		this.daoP.eliminar(cedula);
	}
	
	public void actualizarPersona(Persona persona) {
		this.daoP.actualizar(persona);
	}
}
