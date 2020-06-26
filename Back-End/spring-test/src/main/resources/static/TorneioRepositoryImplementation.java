package br.com.torneio.gerenciador.repository;

import java.util.List;
import java.util.Optional;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Torneio;
///HIATUS - VERIFICAR NECESSIDADE DE MEXER NO CRUD
public class TorneioRepositoryImplementation implements TorneioRepository{

	@Override
	public <S extends Torneio> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Torneio> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Torneio> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Torneio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Torneio> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Torneio entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Torneio> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Torneio> findByAtleta(Atleta atleta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Torneio findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
