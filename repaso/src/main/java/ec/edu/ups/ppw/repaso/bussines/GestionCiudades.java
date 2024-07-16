package ec.edu.ups.ppw.repaso.bussines;

import java.util.List;

import ec.edu.ups.ppw.repaso.dao.CiudadDAO;
import ec.edu.ups.ppw.repaso.model.Ciudad;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCiudades {
	
	@Inject
	private CiudadDAO cdao;
	
	public List<Ciudad> getCiudades() {
		return this.cdao.getAll();
	}
	
	public void insertC(Ciudad c) {
		this.cdao.insert(c);
	}
	
	public Ciudad getCiudad(int id) {
		Ciudad ciudad = this.cdao.read(id);
		return ciudad;
	}
	
	public void deleteCity(int id) {
		this.cdao.delete(id);
	}
	
	public void updatecity(Ciudad ciudad) {
		this.cdao.update(ciudad);
	}
}
