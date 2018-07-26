package com.resttemplate.resttemplate.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.resttemplate.resttemplate.models.Person;

@Service
public class PersonImp implements PersonInt{

	@Autowired
	RestTemplate restTemplate;
	
	final String ROOT_URI = "http://localhost:8080/springData/person";
	
	@Override
	public List<Person> getAllPerson() {
		ResponseEntity<Person[]> response = restTemplate.getForEntity(ROOT_URI, Person[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public Person getById(Long id) {
		ResponseEntity<Person> response = restTemplate.getForEntity(ROOT_URI+"/" + id, Person.class);
		return response.getBody();
	}

	@Override
	public HttpStatus addPerson(Person person) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ROOT_URI, person, HttpStatus.class);
		return response.getBody();
	}

	@Override
	public void updatePerson(Person person) {
		restTemplate.put(ROOT_URI, person);
	}

	@Override
	public void deletePerson(Long id) {
		restTemplate.delete(ROOT_URI + id);
	}

}
