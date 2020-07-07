package br.com.torneio.gerenciador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;

public class AtletaRepositoryImplementation implements AtletaRepository{


@Override
public List<Atleta> findAll() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<Atleta> findAll(Sort sort) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<Atleta> findAllById(Iterable<Long> ids) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <S extends Atleta> List<S> saveAll(Iterable<S> entities) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void flush() {
	// TODO Auto-generated method stub
	
}
@Override
public <S extends Atleta> S saveAndFlush(S entity) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void deleteInBatch(Iterable<Atleta> entities) {
	// TODO Auto-generated method stub
	
}
@Override
public void deleteAllInBatch() {
	// TODO Auto-generated method stub
	
}
@Override
public Atleta getOne(Long id) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <S extends Atleta> List<S> findAll(Example<S> example) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <S extends Atleta> List<S> findAll(Example<S> example, Sort sort) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Page<Atleta> findAll(Pageable pageable) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <S extends Atleta> S save(S entity) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Optional<Atleta> findById(Long id) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean existsById(Long id) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public long count() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public void deleteById(Long id) {
	// TODO Auto-generated method stub
	
}
@Override
public void delete(Atleta entity) {
	// TODO Auto-generated method stub
	
}
@Override
public void deleteAll(Iterable<? extends Atleta> entities) {
	// TODO Auto-generated method stub
	
}
@Override
public void deleteAll() {
	// TODO Auto-generated method stub
	
}
@Override
public <S extends Atleta> Optional<S> findOne(Example<S> example) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <S extends Atleta> Page<S> findAll(Example<S> example, Pageable pageable) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <S extends Atleta> long count(Example<S> example) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public <S extends Atleta> boolean exists(Example<S> example) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public List<Atleta> findByNome(String nome) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Atleta findById(long id) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Iterable<Atleta> findByClube(Clube clube) {
	// TODO Auto-generated method stub
	return null;
}
}
/*
public String getTorneiosConcorridosClubeData() {
	String TorneioClubeData = getTorneiosConcorridos().toString();
	return TorneioClubeData;
}*/