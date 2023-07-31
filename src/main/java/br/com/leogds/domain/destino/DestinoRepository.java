package br.com.leogds.domain.destino;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

	List<Optional<Destino>> findByNome(String nome);

}
