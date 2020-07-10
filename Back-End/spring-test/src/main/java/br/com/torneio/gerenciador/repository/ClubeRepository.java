package br.com.torneio.gerenciador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.torneio.gerenciador.model.Clube;
@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {

	List<Clube> findByNomeClube(String nomeClube);
	Clube findById(long id);
	//void save(Optional<Clube> clubeUpdate);

}
