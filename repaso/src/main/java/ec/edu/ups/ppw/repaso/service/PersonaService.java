package ec.edu.ups.ppw.repaso.service;

import java.util.List;

import ec.edu.ups.ppw.repaso.bussines.GestionPersonas;
import ec.edu.ups.ppw.repaso.model.Persona;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personas")
public class PersonaService {
	
	@Inject
	private GestionPersonas gestionP;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response obtenerPersonas() {
		List<Persona> personas = this.gestionP.obtenerPersonas();
		return Response.ok(personas).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{cedula}")
	public Response obtenerPersona(@PathParam("cedula") String cedula) {
		Persona persona = this.gestionP.obtenerPersona(cedula);
		return Response.ok(persona).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserarPersona(Persona persona) {
		this.gestionP.insertarPersona(persona);
		return Response.ok().build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{cedula}")
	public Response eliminarPersona(@PathParam("cedula") String cedula) {
		this.gestionP.borrarPersona(cedula);
		return Response.ok().build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response actualizarPersona(Persona persona) {
		this.gestionP.actualizarPersona(persona);
		return Response.ok().build();
	}
}
