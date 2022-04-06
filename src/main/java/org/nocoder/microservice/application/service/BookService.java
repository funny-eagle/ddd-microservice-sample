package org.nocoder.microservice.application.service;

import org.nocoder.microservice.application.dto.BookDto;
import org.nocoder.microservice.application.exception.BookServiceException;

/**
 * BookService
 *
 * @author yangjinlong
 */
public interface BookService {
    public int addBook(BookDto book) throws BookServiceException;

    public BookDto getBookById(long id) throws BookServiceException;
}
