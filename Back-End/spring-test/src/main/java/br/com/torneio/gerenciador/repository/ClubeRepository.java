package br.com.torneio.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.torneio.gerenciador.model.Clube;
@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {

	List<Clube> findByNomeClube(String nomeClube);

}
