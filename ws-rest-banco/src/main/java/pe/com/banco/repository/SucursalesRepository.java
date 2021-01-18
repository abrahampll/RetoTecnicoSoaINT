package pe.com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.banco.model.Sucursales;

@Repository
public interface SucursalesRepository extends JpaRepository<Sucursales, Integer> {

	Sucursales findByIdSucursal(Integer idSucursal);
	
//	 <S extends Sucursales> S save(S entity); 
//	 void delete(Sucursales entity); 
}
