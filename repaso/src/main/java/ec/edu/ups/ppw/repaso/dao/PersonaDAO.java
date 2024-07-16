package ec.edu.ups.ppw.repaso.dao;

import java.util.List;

import ec.edu.ups.ppw.repaso.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Persona leer(String cedula) {
		Persona persona = this.em.find(Persona.class, cedula);
		return persona;
	}
	
	public List<Persona> obtenerTodo() {
		String jpql = "SELECT c FROM Persona c";
		Query query = this.em.createQuery(jpql, Persona.class);
		return query.getResultList();
	}
	
	public void insertar(Persona persona) {
		this.em.persist(persona);
	}
	
	public void eliminar(String cedula) {
		Persona p = this.leer(cedula);
		this.em.remove(p);
	}
	
	public void actualizar(Persona persona) {
		this.em.merge(persona);
	}
 }
