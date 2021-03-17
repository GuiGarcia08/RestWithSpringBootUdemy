package br.com.guilherme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guilherme.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
