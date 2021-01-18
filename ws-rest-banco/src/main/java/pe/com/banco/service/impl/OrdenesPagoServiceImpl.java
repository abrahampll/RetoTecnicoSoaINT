package pe.com.banco.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.banco.model.OrdenesPago;
import pe.com.banco.repository.OrdenesRepository;
import pe.com.banco.service.OrdenesPagoService;

@Service
@Transactional
public class OrdenesPagoServiceImpl implements OrdenesPagoService {

	private OrdenesRepository ordenesRepository;
	
	@Override
	public Optional<OrdenesPago> save(OrdenesPago user) {
		return Optional.of(ordenesRepository.save(user));
	}

	@Override
	public Optional<OrdenesPago> findById(int id) {
		return Optional.of(ordenesRepository.findByIdOrdenPago(id));
	}

	@Override
	public Optional<List<OrdenesPago>> findAll() {
		return Optional.of(ordenesRepository.findAll());
	}

	@Override
	public Optional<OrdenesPago> update(int id, OrdenesPago user) {
	
		if(this.findById(id).isPresent()) {
			user.setIdOrdenPago(id);
			return this.save(user);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void deleteById(int id) {
//		ordenesRepository.delete(id);
		ordenesRepository.deleteById(id);

	}

}
