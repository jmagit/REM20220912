package com.example;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ActorRepository dao;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");
		
//		var actor = dao.findById(1);
//		if(actor.isPresent())
//			System.out.println(actor.get());
		
//		var item = new Actor();
//		item.setFirstName("Pepito");
//		item.setLastName("Grillo");
//		dao.save(item);
//		dao.findAll().forEach(System.out::println);

//		var actor = dao.findById(201);
//		if(actor.isPresent()) {
//			var item = actor.get();
//			item.setFirstName(item.getFirstName().toUpperCase());
//			item.setLastName(item.getLastName().toUpperCase());
//			dao.save(item);
//			System.out.println("Modifico");
//		}
//		var item = new Actor(202);
//		item.setFirstName("Pepitoooooooooo");
//		item.setLastName("Grillo");
//		dao.save(item);
//		dao.deleteById(201);
//		dao.findAll().forEach(System.out::println);
//		dao.findTop3ByFirstNameStartingWithOrderByFirstNameDesc("pe").forEach(System.out::println);
//		dao.findTop3ByFirstNameStartinWithOrderByFirstNameDesc("MIRANDA").forEach(System.out::println);
//		dao.findByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.findByActorIdBetween(10, 20).forEach(System.out::println);
//		dao.dameConApellido("MIRANDA").forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThanOrEqualTo(root.get("actorId"), 10)).forEach(System.out::println);
//		var actor = dao.findById(1);
//		if(actor.isPresent()) {
//			System.out.println(actor.get());
//			actor.get().getFilmActors().forEach(item -> System.out.println(item.getFilm().getTitle()));
//		}
//		var item = new Actor(202);
//		item.setFirstName("P");
//		item.setLastName("12345678Z");
//		if(item.isValid())
//		dao.save(item);
//		else {
//			System.out.println(item.getErrorsMessage());
//		}

	}

}
