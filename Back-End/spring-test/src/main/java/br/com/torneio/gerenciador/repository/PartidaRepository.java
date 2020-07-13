package br.com.torneio.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Partida;

public interface PartidaRepository extends JpaRepository<Partida, String>{

}
