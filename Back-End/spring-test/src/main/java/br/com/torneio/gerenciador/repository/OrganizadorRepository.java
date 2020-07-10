package br.com.torneio.gerenciador.repository;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.torneio.gerenciador.model.Organizador;


@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, String>{

	Organizador findById(long id);
	//void save(Optional<Organizador> organizadorUpdate); //RETIRAR URGENTEMENTE O OPTIONAL DO findById, custe o que custar

	Organizador findByEmail(@NotEmpty(message = "Digite um email cadastrado") String email);
}
