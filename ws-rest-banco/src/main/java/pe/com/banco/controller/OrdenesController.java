package pe.com.banco.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.banco.model.OrdenesPago;
import pe.com.banco.service.OrdenesPagoService;

@Path("/ordenpago")
@Api(value = "/ordenpago")
@Produces(MediaType.APPLICATION_JSON)
public class OrdenesController {
	
	@Autowired
	private OrdenesPagoService ordenesPagoService; 
	
	@Path("/saveOrdenPago")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public OrdenesPago save(final OrdenesPago user) {
		return ordenesPagoService.save(user).get();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "busqueda por IdPago")
	public OrdenesPago findById(@PathParam("id") final int userId) {
		return ordenesPagoService.findById(userId).get();
	}

	@GET
	@ApiOperation(value = "Listado de Ordenes de Pago", response = OrdenesPago.class)
	public List<OrdenesPago> findAll() {
		return ordenesPagoService.findAll().get();
	}
	
	
	   @PUT
	    @Path("/{id}")
	    @ApiOperation(value = "Actualiza si existe ordenPago")
	    public OrdenesPago update(@PathParam("id") final int id,
	                       final OrdenesPago user) {
	        return ordenesPagoService.update(id, user).get();
	    }

	    @DELETE
	    @Path("/{id}")
	    @ApiOperation(value = "Eliminacion de ordendePago")
	    public void deleteById(@PathParam("id") final int userId) {
	    	ordenesPagoService.deleteById(userId);
	    }

}
