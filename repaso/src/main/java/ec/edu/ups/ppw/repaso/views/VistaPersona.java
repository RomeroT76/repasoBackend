package ec.edu.ups.ppw.repaso.views;

import java.util.List;

import ec.edu.ups.ppw.repaso.bussines.GestionPersonas;
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
	
	@PostConstruct
	public void init() {
		this.personas = this.gestionP.obtenerPersonas();
	}
}
