package br.com.torneio.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Partidas;

public interface PartidasRepository extends JpaRepository<Partidas, String>{

}
