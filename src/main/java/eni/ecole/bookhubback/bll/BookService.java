package eni.ecole.bookhubback.bll;


import eni.ecole.bookhubback.bo.Book;
import eni.ecole.bookhubback.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    BookRepository bookRepository;

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
