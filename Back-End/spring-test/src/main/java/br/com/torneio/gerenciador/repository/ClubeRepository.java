package br.com.torneio.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;

public interface ClubeRepository extends JpaRepository<Clube, Long> {

	List<Clube> findByNomeClube(String nomeClube);
	//List<Atleta> findByAtletas(Atleta atleta);

}
