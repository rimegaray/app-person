package com.example.api.service.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.api.controller.model.Person;
import com.example.api.repository.entity.PersonEntity;

@Component
public class PersonEntityConverter implements Converter<Person, PersonEntity>{

	@Override
	public PersonEntity convert(Person source) {
		return PersonEntity.builder()
				.name(source.getName())
				.lastname(source.getLastname())
				.dni(source.getDni())
				.isEmployee(source.isEmployee())
				.build();
	}

}
