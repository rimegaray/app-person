package com.example.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.api.repository.entity.PersonEntity;

@Repository
public interface IPersonRepository extends CrudRepository<PersonEntity, Integer> {
}
