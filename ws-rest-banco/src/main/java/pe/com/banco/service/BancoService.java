package pe.com.banco.service;

import java.util.List;
import java.util.Optional;

import pe.com.banco.exception.ResourceNotFoundException;
import pe.com.banco.model.Banco;

public interface BancoService {

	Optional<Banco> save(Banco user);

	List<Banco> findAll();

	Optional<Banco> findById(int idBanco) throws ResourceNotFoundException;

	void delete(Banco banco);

	Optional<Banco> update(int id, Banco banco) throws ResourceNotFoundException;

}
