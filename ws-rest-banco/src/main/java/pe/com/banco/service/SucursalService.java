package pe.com.banco.service;

import java.util.List;
import java.util.Optional;

import pe.com.banco.model.Sucursales;

public interface SucursalService {
	  	Optional<Sucursales> save(Sucursales user);

	    Optional<Sucursales> findById(int id);

	    Optional<List<Sucursales>> findAll();

	    Optional<Sucursales> update(int id, Sucursales sucursal);

	    void deleteById(int id);
}
