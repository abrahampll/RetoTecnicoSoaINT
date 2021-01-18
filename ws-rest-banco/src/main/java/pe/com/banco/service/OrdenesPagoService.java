package pe.com.banco.service;

import java.util.List;
import java.util.Optional;

import pe.com.banco.model.OrdenesPago;

public interface OrdenesPagoService {
	
	Optional<OrdenesPago> save(OrdenesPago user);

    Optional<OrdenesPago> findById(int id);

    Optional<List<OrdenesPago>> findAll();

    Optional<OrdenesPago> update(int id, OrdenesPago user);

    void deleteById(int id);

}
