package edu.altair.crmAltair.repositories;
import edu.altair.crmAltair.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	
	boolean existsByCodigo(Long codigo);
	
	Optional<Departamento> findByCodigo(Long codigo);
	
}
