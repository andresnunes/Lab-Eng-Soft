package br.com.torneio.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.model.Torneio;

public interface AtletaRepository extends JpaRepository<Atleta,Long>{
	
	List<Atleta> findByNome(String nome);
	Atleta findById(long id);
	Iterable<Atleta> findByClube(Clube clube);
	
	//procurar todos os atletas do torneio
	//Iterable<Atleta> findByTorneio(Torneio torneio);
}
