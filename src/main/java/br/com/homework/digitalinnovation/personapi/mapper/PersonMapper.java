package br.com.homework.digitalinnovation.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.homework.digitalinnovation.personapi.dto.request.PersonDTO;
import br.com.homework.digitalinnovation.personapi.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO personDto);
	
	PersonDTO toDTO(Person person);
}
