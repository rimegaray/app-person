package com.example.api.controller;

import com.example.api.controller.model.Person;
import com.example.api.service.IPersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private IPersonService service;
	
	@PostMapping()
	public Mono<Person> createPerson(@RequestBody Person person){
		return service.add(person);
	}
	
	@GetMapping()
	public Flux<Person> getPersons(){
		return service.getAll();
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deletePerson(@PathVariable Integer id){
		return service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Mono<Person> updatePerson(@PathVariable Integer id, @RequestBody Person person){
		return service.update(person, id);
	}
	
	
}
