package pe.com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.banco.model.OrdenesPago;

@Repository
public interface OrdenesRepository  extends JpaRepository<OrdenesPago, Integer>{

	
	OrdenesPago findByIdOrdenPago(Integer idOrdenPago);
//    List<OrdenesPago> findByIdName(String name);
//	 <S extends OrdenesPago> S save(S entity); 
//	 void delete(OrdenesPago entity); 

}
