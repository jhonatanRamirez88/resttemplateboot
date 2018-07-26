package com.resttemplate.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import com.resttemplate.resttemplate.models.Person;
import com.resttemplate.resttemplate.service.PersonInt;

@SpringBootApplication
public class ResttemplateApplication implements CommandLineRunner{

	@Autowired
	PersonInt personInt;
	
	public static void main(String[] args) {
		SpringApplication.run(ResttemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Obteniendo la lista de personas");
		for(Person p : personInt.getAllPerson()) {
			System.out.println(p);
		}
		System.out.println("Obteniendo persona con el ID 2");
		Person person = personInt.getById(2L);
		System.out.println(person);
		
		System.out.println("Agregando una persona");
		Person p = new Person();
		p.setAge(50);
		p.setFirstName("Jhonatan");
		p.setLastName("Ramirez");
		HttpStatus httpStatus = personInt.addPerson(p);
		System.out.println("El agregado de una persona devolvio el status: "+ httpStatus);
	}
}
