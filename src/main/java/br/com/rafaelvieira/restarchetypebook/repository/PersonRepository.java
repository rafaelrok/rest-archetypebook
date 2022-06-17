package br.com.rafaelvieira.restarchetypebook.repository;

import br.com.rafaelvieira.restarchetypebook.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
