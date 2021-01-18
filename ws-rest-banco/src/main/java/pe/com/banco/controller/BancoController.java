package pe.com.banco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import pe.com.banco.exception.ResourceNotFoundException;
import pe.com.banco.model.Banco;
import pe.com.banco.service.BancoService;

@Component("BancoResourceV1")
@Path("/banco")
@Api(value = "/banco", consumes = MediaType.APPLICATION_JSON,  produces = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BancoController {

	
	@Autowired
	private BancoService bancoService;

	@Path("/saveBank")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@POST
	public ResponseEntity<?>  save(@RequestBody final Banco user) {
		 bancoService.save(user).get();
		 return ResponseEntity.ok("add Bank");
		 
	}

	@Path("/getBankid")
	@ApiOperation(value = "busqueda por IdBanco")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public ResponseEntity<Banco> findById(@QueryParam("id") final int id) throws ResourceNotFoundException {
		Optional<Banco>  objBanco = bancoService.findById(id);
		
		
				
		return ResponseEntity.ok().body(objBanco.get());
	}

	@Path("/getBank")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Listado de Bancos", response = Banco.class)
	@GET
	public List<Banco> findAll() {
	    return bancoService.findAll(); 
	}

	@PUT
	@Path("/putBank")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Actualiza si existe IdBanco")
	@ApiResponse(code = 404, message = "Banco not found")
	public Banco update(@QueryParam("id") final int id, final Banco user) throws ResourceNotFoundException {
		return bancoService.update(id, user).get();
	}

	@DELETE
	@Path("/deletebank")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Eliminacion de IdBanco")
	public Map<String, Boolean> deleteById(@QueryParam("userId") final int userId) throws ResourceNotFoundException {
		Banco  objBanco = bancoService.findById(userId).get();
				
		
		bancoService.delete(objBanco);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
			
	}
	
	
}
