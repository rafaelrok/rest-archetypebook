package br.com.rafaelvieira.restarchetypebook.repository;

import br.com.rafaelvieira.restarchetypebook.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
