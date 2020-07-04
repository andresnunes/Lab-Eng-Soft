package br.com.torneio.gerenciador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.model.Torneio;



@Repository
public interface TorneioRepository extends CrudRepository<Torneio, String>{
	//List<Atleta> adicionarAtletaAoTorneio(Torneio torneio, Atleta atleta);
	
	//procurar todos os torneios do atleta
	//Iterable<Torneio> findByAtleta(Atleta atleta);

    Torneio findById(long id);
    Iterable<Torneio> findByClube(Clube clube);
}
