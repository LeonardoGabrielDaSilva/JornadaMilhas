package br.com.leogds.domain.depoimento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long>{

	@Query(value = "SELECT d FROM Depoimento d ORDER BY RANDOM() LIMIT 3")
	List<Depoimento> find3Random();

}
