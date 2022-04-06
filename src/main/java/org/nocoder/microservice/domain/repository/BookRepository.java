package org.nocoder.microservice.domain.repository;

import org.nocoder.microservice.domain.modal.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

    int addBook(Book book);

    Book getById(long id);
}
