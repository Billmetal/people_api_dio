package br.com.homework.digitalinnovation.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import br.com.homework.digitalinnovation.personapi.dto.request.PersonDTO;
import br.com.homework.digitalinnovation.personapi.entity.Person;

public class PersonUtils {
	
	private static final String FIRST_NAME = "Rodrigo";
	private static final String LAST_NAME = "Peleias";
	private static final String CPF_NUMBER = "369.333.878-79";
	private static final Long PERSON_ID = 1L;
	private static final LocalDate BIRTH_DATE = LocalDate.of(2001,4,15);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder().firstName(FIRST_NAME).lastName(LAST_NAME)
					.cpf(CPF_NUMBER).birthDate("04-04-2001")
					.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
					.build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder().id(PERSON_ID).firstName(FIRST_NAME).lastName(LAST_NAME)
					.cpf(CPF_NUMBER).birthDate(BIRTH_DATE)
					.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
					.build();
	}

}
