package com.example.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.example.api.controller.model.Person;
import com.example.api.repository.IPersonRepository;
import com.example.api.repository.entity.PersonEntity;
import com.example.api.service.IPersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService implements IPersonService {

	@Autowired
	IPersonRepository personRepository;
	@Autowired
	Converter<PersonEntity, Person> personConverter;
	@Autowired
	Converter<Person, PersonEntity> personEntityConverter;

	@Override
	public Mono<Void> deleteById(Integer id) {
		personRepository.deleteById(id);
		return Mono.empty();
	}

	@Override
	public Mono<Person> add(Person person) {
		return Mono.just(person).map(personEntityConverter::convert)
				.map(personRepository::save)
				.map(personConverter::convert);
	}

	@Override
	public Mono<Person> update(Person person, Integer id) {
		return Mono.just(id)
				.map(personId -> personRepository.findById(personId)
						.map(entity -> modify(entity, person))
						.orElseThrow())
				.map(personRepository::save)
				.map(personConverter::convert);
	}
	
	private PersonEntity modify(PersonEntity entity, Person person){
		entity.setName(person.getName());
		entity.setLastname(person.getLastname());
		entity.setEmployee(person.isEmployee());
		entity.setDni(person.getDni());
		return entity;
	}

	@Override
	public Flux<Person> getAll() {
		return Flux.fromIterable(personRepository.findAll())
				.map(personConverter::convert);
	}

}
