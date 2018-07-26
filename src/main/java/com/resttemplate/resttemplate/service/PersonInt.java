package com.resttemplate.resttemplate.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.resttemplate.resttemplate.models.Person;

public interface PersonInt {
	List<Person> getAllPerson();
	Person getById(Long id);
	HttpStatus addPerson(Person person);
	void updatePerson(Person person);
	void deletePerson(Long id);
}
