package pe.com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.banco.model.Banco;


@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

	
	Banco findByIdBanco(Integer idBanco);

	
	 
}
