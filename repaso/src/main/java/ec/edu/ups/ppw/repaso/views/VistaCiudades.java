package ec.edu.ups.ppw.repaso.views;

import java.util.List;

import ec.edu.ups.ppw.repaso.bussines.GestionCiudades;
import ec.edu.ups.ppw.repaso.model.Ciudad;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("vCiudades")
@RequestScoped
public class VistaCiudades {
	
	@Inject
	private GestionCiudades gc;
	
	private Ciudad ciudad = new Ciudad();
	
	private int id;
	
	private List<Ciudad> ciudades;
	
	public GestionCiudades getGc() {
		return gc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGc(GestionCiudades gc) {
		this.gc = gc;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
	public String registrar() {
		this.gc.insertC(ciudad);
		return "ListadoCiudades?faces-redirect=true";
	}
	
	public String regresar() {
		return "RegistroCiudades?faces-redirect=true";
	}
	
	public String verListado() {
		return "ListadoCiudades?faces-redirect=true";
	}
	
	public String elimnar() {
		this.gc.deleteCity(id);
		return "RegistroCiudades?faces-redirect=true";
	}
	
	public String actualizar() {
		this.gc.updatecity(ciudad);
		return "ListadoCiudades?faces-redirect=true";
	}

	@PostConstruct()
	public void init() {
		this.ciudades = this.gc.getCiudades();
	}
}
