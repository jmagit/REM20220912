package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domains.entities.Actor;

@RepositoryRestResource(exported = false)
public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor>  {
	List<Actor> findTop3ByFirstNameStartingWithOrderByFirstNameDesc(String prefijo);
	List<Actor> findByActorIdGreaterThan(int inicial);
	List<Actor> findByActorIdBetween(int inicial, int ultimo);
	@Query("SELECT a FROM Actor a where a.lastName = ?1")
	List<Actor> findTop3ByFirstNameStartinWithOrderByFirstNameDesc(String prefijo);
	@Query(value = "SELECT * FROM actor where last_name = ?1", nativeQuery = true)
	List<Actor> dameConApellido(String prefijo);
	
	@Query("SELECT a FROM Actor a")
	<T> List<T> dameTodos(Class<T> type);
	
	<T> List<T> findByActorIdIsNotNull(Class<T> type);
	<T> Iterable<T> findByActorIdIsNotNull(Sort sort, Class<T> type);
	<T> Page<T> findByActorIdIsNotNull(Pageable pageable, Class<T> type);

}
