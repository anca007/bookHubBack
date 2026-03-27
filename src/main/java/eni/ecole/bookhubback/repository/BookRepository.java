package eni.ecole.bookhubback.repository;

import eni.ecole.bookhubback.bo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
