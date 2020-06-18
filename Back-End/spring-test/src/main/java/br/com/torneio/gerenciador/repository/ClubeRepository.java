package br.com.torneio.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Clube;

public interface ClubeRepository extends JpaRepository<Clube, Long> {

	Clube findByNome(String nome);

}
