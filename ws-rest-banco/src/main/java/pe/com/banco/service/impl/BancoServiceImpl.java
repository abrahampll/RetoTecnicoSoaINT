package pe.com.banco.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.banco.exception.ResourceNotFoundException;
import pe.com.banco.model.Banco;
import pe.com.banco.repository.BancoRepository;
import pe.com.banco.service.BancoService;

@Service
@Transactional
public class BancoServiceImpl implements BancoService {
	
	@Autowired
	private BancoRepository  bancoRepository;

	@Override
	public Optional<Banco> save(final Banco user) {
		return Optional.of(bancoRepository.save(user));
	}
	
	
	 @Override
	    public List<Banco> findAll() {
		 return bancoRepository.findAll();
	 }
	 
	 @Override
	public   Optional<Banco> findById(final int idBanco) throws ResourceNotFoundException{
		 
		 return Optional.of(bancoRepository.findByIdBanco(idBanco));
	 }

	@Override
	public Optional<Banco> update(int id, Banco banco) throws ResourceNotFoundException {
		Optional<Banco> objBanco= Optional.of(bancoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Banco no encontrado")));
		if(objBanco.isPresent()) {
			objBanco.get().setDireccion(banco.getDireccion());
			objBanco.get().setFechaRegistro(banco.getFechaRegistro());
			objBanco.get().setNombre(banco.getNombre());
			return this.save(objBanco.get());
		} else {
			throw new NoSuchElementException();
		}
		
	}
	@Override
	public void delete(Banco banco) {
		bancoRepository.delete(banco);
	}


}
