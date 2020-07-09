package br.com.torneio.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta,Long>{
	
	List<Atleta> findByNome(String nome);
	Atleta findById(long id);
	Iterable<Atleta> findByClube(Clube clube);
}
