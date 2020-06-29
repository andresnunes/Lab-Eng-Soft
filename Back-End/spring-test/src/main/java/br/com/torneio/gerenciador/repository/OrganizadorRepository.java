package br.com.torneio.gerenciador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.torneio.gerenciador.model.Organizador;


@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, String>{
	Optional<Organizador> findById(long id);
	Optional<Organizador> findByEmail(String email);
}
