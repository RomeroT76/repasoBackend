package ec.edu.ups.ppw.repaso.dao;

import java.util.List;

import ec.edu.ups.ppw.repaso.model.Ciudad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CiudadDAO {
	
	@PersistenceContext
	private EntityManager emg;
	
	public Ciudad read(int id) {
		Ciudad ciudad = this.emg.find(Ciudad.class, id);
		return ciudad;
		
	}
	
	public List<Ciudad> getAll() {
		String jpql = "SELECT c FROM Ciudad c";
		Query query = this.emg.createQuery(jpql, Ciudad.class);
		return query.getResultList();
	}
	
	public void insert(Ciudad ciudad) {
		this.emg.persist(ciudad);
	}
	
	public void delete(int id) {
		Ciudad ciudad = this.read(id);
		this.emg.remove(ciudad);
	}
	
	public void update(Ciudad c) {
		this.emg.merge(c);
	}
}
