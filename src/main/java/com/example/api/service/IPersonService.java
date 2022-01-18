package com.example.api.service;

import com.example.api.controller.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {
  Mono<Void> deleteById(Integer id);
  Mono<Person> add(Person person);
  Mono<Person> update(Person person, Integer id);
  Flux<Person> getAll();
}
