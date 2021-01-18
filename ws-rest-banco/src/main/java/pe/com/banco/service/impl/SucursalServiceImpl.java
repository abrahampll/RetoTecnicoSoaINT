package pe.com.banco.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.banco.model.Sucursales;
import pe.com.banco.repository.SucursalesRepository;
import pe.com.banco.service.SucursalService;
@Service
@Transactional
public class SucursalServiceImpl implements SucursalService {

	private SucursalesRepository  sucursalesRepository; 
	
	@Override
	public Optional<Sucursales> save(Sucursales user) {
		return Optional.of(sucursalesRepository.save(user));
	}

	@Override
	public Optional<Sucursales> findById(int id) {
		return Optional.of(sucursalesRepository.findByIdSucursal(id));
	}

	@Override
	public Optional<List<Sucursales>> findAll() {
		return Optional.of(sucursalesRepository.findAll());
	}

	@Override
	public Optional<Sucursales> update(int id, Sucursales user) {
		
		if(this.findById(id).isPresent()) {
			user.setIdSucursal(id);
			return this.save(user);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void deleteById(int id) {
//		sucursalesRepository.delete(id);
		sucursalesRepository.deleteById(id);
	}

}
