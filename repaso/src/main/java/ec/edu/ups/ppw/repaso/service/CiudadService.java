package ec.edu.ups.ppw.repaso.service;

import java.util.List;

import ec.edu.ups.ppw.repaso.bussines.GestionCiudades;
import ec.edu.ups.ppw.repaso.model.Ciudad;
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

@Path("/ciudades")
public class CiudadService {
	
	@Inject
	private GestionCiudades gc;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCiudades() {
		List<Ciudad> ciudades = this.gc.getCiudades();
		return Response.ok(ciudades).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertC(Ciudad ciudad) {
		this.gc.insertC(ciudad);
		return Response.ok(ciudad).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{nombre}")
	public Response getCiudad(@PathParam("nombre") int id) {
		Ciudad ciudad = this.gc.getCiudad(id);
		return Response.ok(ciudad).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deleteCiudad(@PathParam("id") int id) {
		this.gc.deleteCity(id);
		return Response.ok().build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateCity(Ciudad ciudad) {
		this.gc.updatecity(ciudad);
		return Response.ok().build();
	}
}
