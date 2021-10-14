package br.com.homework.digitalinnovation.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homework.digitalinnovation.personapi.dto.request.PersonDTO;
import br.com.homework.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import br.com.homework.digitalinnovation.personapi.entity.Person;
import br.com.homework.digitalinnovation.personapi.exception.PersonNotFoundException;
import br.com.homework.digitalinnovation.personapi.mapper.PersonMapper;
import br.com.homework.digitalinnovation.personapi.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDto) {
		Person personToSave = personMapper.toModel(personDto);
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO.builder().message("Created person with ID "+savedPerson.getId()).build();
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException{
		return personMapper.toDTO(verifyIfExists(id));
	}

	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		personRepository.deleteById(id);
	}
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
}
