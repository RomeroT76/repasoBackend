package ec.edu.ups.ppw.repaso.views;

import java.util.List;

import ec.edu.ups.ppw.repaso.bussines.GestionCiudades;
import ec.edu.ups.ppw.repaso.bussines.GestionPersonas;
import ec.edu.ups.ppw.repaso.model.Ciudad;
import ec.edu.ups.ppw.repaso.model.Persona;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("personas")
@RequestScoped
public class VistaPersona {
	
	@Inject
	private GestionPersonas gestionP;
	
	private Persona persona = new Persona();
	
	private Ciudad ciudad = new Ciudad();
	
	private List<Persona> personas;
	
	private String cedula;
	
	public GestionPersonas getGestionP() {
		return gestionP;
	}

	public void setGestionP(GestionPersonas gestionP) {
		this.gestionP = gestionP;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String registrarPersona() {
		this.gestionP.insertarPersona(persona);
		return "ListadoCiudades?faces-redirect=true";
	}
	
	public String eliminarPersona() {
		this.gestionP.borrarPersona(cedula);
		return "RegistroCiudades?faces-redirect=true";
	}
	
	public String actualizarPersona() {
		this.gestionP.actualizarPersona(persona);
		return "ListadoCiudades?faces-redirect=true";
	}
	
	@PostConstruct
	public void init() {
		this.personas = this.gestionP.obtenerPersonas();
		this.persona.setCiudad(ciudad);
	}
}
