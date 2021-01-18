package pe.com.banco.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.banco.model.Sucursales;
import pe.com.banco.service.SucursalService;

@RestController
@RequestMapping("/sucursal/v1")
@Api(value = "/sucursales")
@Produces(MediaType.APPLICATION_JSON)
public class SucursalesController {
	
	@Autowired
	private SucursalService sucursalService; 
	
	
	@PostMapping("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Sucursales save(final Sucursales user) {
		return sucursalService.save(user).get();
	}


	@Path("/{id}")
	@ApiOperation(value = "busqueda por IdSucursal")
	public Sucursales findById(@PathParam("id") final int userId) {
		return sucursalService.findById(userId).get();
	}

	@GET
	@ApiOperation(value = "Listado de Sucursale", response = Sucursales.class)
	public List<Sucursales> findAll() {
		return sucursalService.findAll().get();
	}
	
	
	   @PUT
	    @Path("/{id}")
	    @ApiOperation(value = "Actualiza si existe idSucursal")
	    public Sucursales update(@PathParam("id") final int id,
	                       final Sucursales user) {
	        return sucursalService.update(id, user).get();
	    }

	    @DELETE
	    @Path("/{id}")
	    @ApiOperation(value = "Eliminacion de sucursal")
	    public void deleteById(@PathParam("id") final int userId) {
	    	sucursalService.deleteById(userId);
	    }

}
