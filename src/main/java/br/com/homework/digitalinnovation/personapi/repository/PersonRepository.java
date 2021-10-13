package br.com.homework.digitalinnovation.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homework.digitalinnovation.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{

	
}
