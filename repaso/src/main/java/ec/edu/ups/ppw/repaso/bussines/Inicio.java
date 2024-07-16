package ec.edu.ups.ppw.repaso.bussines;

import java.util.List;

import ec.edu.ups.ppw.repaso.dao.CiudadDAO;
import ec.edu.ups.ppw.repaso.model.Ciudad;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	
	@Inject
	private CiudadDAO cDao;
	
	@PostConstruct
	public void init() {
		
		Ciudad c1 = new Ciudad();
		c1.setid(1);
		c1.setNombre("Cuenca");
		cDao.insert(c1);
		
//		List<Ciudad> ciudades = cDao.getAll();
//		for(Ciudad c : ciudades) {
//			System.out.println(c.getCiu_id() + " " + c.getNombre());
//		}
	}
}
