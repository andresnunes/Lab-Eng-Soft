package br.com.torneio.gerenciador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.torneio.gerenciador.model.Organizador;



@Repository
public interface OrganizadorRepository extends CrudRepository<Organizador, String>{

}
