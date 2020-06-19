package br.com.torneio.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Clube;

public interface ClubeRepository extends JpaRepository<Clube, Long> {

	List<Clube> findByNome(String nome);

}
