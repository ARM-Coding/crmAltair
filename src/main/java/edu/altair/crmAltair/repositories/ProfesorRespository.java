package edu.altair.crmAltair.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.crmAltair.entities.Profesor;

@Repository
public interface ProfesorRespository extends JpaRepository<Profesor, Long> {
	
	boolean existsByDni(String dni);
	
	Optional<Profesor> findByDni(String dni);
	
	List<Profesor> findByDepartamento_IdDepartamento(Long idDepartamento);

}
