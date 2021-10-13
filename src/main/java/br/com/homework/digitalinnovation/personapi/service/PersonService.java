package br.com.homework.digitalinnovation.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.homework.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import br.com.homework.digitalinnovation.personapi.entity.Person;
import br.com.homework.digitalinnovation.personapi.repository.PersonRepository;

@Service
public class PersonService {

private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.builder().message("Created person with ID "+savedPerson.getId()).build();
	}
}
