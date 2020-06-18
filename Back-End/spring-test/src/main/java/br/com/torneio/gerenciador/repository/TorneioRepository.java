package br.com.torneio.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Torneio;

public interface TorneioRepository extends JpaRepository<Torneio, Long>{

}
