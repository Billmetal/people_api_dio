package br.com.homework.digitalinnovation.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homework.digitalinnovation.personapi.dto.request.PersonDTO;
import br.com.homework.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import br.com.homework.digitalinnovation.personapi.entity.Person;
import br.com.homework.digitalinnovation.personapi.exception.PersonNotFoundException;
import br.com.homework.digitalinnovation.personapi.mapper.PersonMapper;
import br.com.homework.digitalinnovation.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	public MessageResponseDTO createPerson(PersonDTO personDto) {
		Person personToSave = personMapper.toModel(personDto);
		Person savedPerson = personRepository.save(personToSave);
		return createMessageResponse(savedPerson.getId(),"Created person with ID ");
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

	public MessageResponseDTO updateById(Long id, @Valid PersonDTO personDto) throws PersonNotFoundException {
		verifyIfExists(id);
		Person personToSave = personMapper.toModel(personDto);
		Person savedPerson = personRepository.save(personToSave);
		return createMessageResponse(savedPerson.getId(),"Update person with ID ");
	}
	
	private MessageResponseDTO createMessageResponse(Long id,String s) {
		return MessageResponseDTO.builder().message(s + id).build();
	}
}
