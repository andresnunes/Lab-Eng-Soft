package br.com.torneio.gerenciador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.model.Torneio;

@Repository
public interface TorneioRepository extends CrudRepository<Torneio, String>{
    Torneio findById(long id);
    Iterable<Torneio> findByClube(Clube clube);
}
