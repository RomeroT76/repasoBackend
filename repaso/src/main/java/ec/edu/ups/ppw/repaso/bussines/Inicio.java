package ec.edu.ups.ppw.repaso.bussines;

import java.util.List;

import ec.edu.ups.ppw.repaso.dao.CiudadDAO;
import ec.edu.ups.ppw.repaso.dao.PersonaDAO;
import ec.edu.ups.ppw.repaso.model.Ciudad;
import ec.edu.ups.ppw.repaso.model.Persona;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	
	@Inject
	private CiudadDAO cDao;
	
	@Inject
	private PersonaDAO pDao;
	
	@PostConstruct
	public void init() {
		
		Ciudad c1 = new Ciudad();
		c1.setid(1);
		c1.setNombre("Cuenca");
		cDao.insert(c1);
		
		Persona p1 = new Persona();
		p1.setCedula("0706623873");
		p1.setNombre("Roberto Romero");
		p1.setCiudad(c1);
		pDao.insertar(p1);
		
//		List<Ciudad> ciudades = cDao.getAll();
//		for(Ciudad c : ciudades) {
//			System.out.println(c.getid() + " " + c.getNombre());
//		}
//		
//		List<Persona> personas = pDao.obtenerTodo();
//		for(Persona p : personas) {
//			System.out.println(p.getCedula() + " " + p.getNombre() + " " + p.getCiudad().getNombre());
//		}
		
	}
}
