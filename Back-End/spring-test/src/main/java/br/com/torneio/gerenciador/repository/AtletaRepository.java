package br.com.torneio.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.model.Torneio;

public interface AtletaRepository extends JpaRepository<Atleta,Long>{
	
	List<Atleta> findByNome(String nome);
	Atleta findById(long id);
	Iterable<Atleta> findByClube(Clube clube);
	//List<Torneio> countTorneiosVencidos(Atleta atleta);
	//List<Torneio> findBytorneiosConcorridos(Atleta atleta);
	//List<Torneio> findBytorneiosVencidos(Atleta atleta);
	//procurar todos os atletas do torneio
	//Iterable<Atleta> findByTorneio(Torneio torneio);
	
	/*
	 * https://stackoverflow.com/questions/45708748/returning-value-from-a-many-to-many-relationship
	 * 
	 * 
	@Query(value = "w.id, w.id_author, b.id, b.title, b.year, a.id_author, a.name, a.surname 
			FROM Book b
			INNER JOIN
			Written w on b.id = w.id
			INNER JOIN 
			Author a on w.id_author = a.id_author ", nativeQuery = true)
			public List <IntersectionResult> findAllIntersectedColumn ();
	https://stackoverflow.com/questions/59398797/display-many-to-many-relationships-data-with-thymeleaf-in-spring-application

http://www.mballem.com/post/consultas-com-hibernate-e-a-api-criteria-parte-ii/
			*
			*/
}
