package br.com.torneio.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta,Long>{
	
	List<Atleta> findByNome(String nome);

}
