package org.nocoder.microservice.application.service.impl;

import org.apache.commons.lang.Validate;
import org.nocoder.microservice.application.assembler.BookAssembler;
import org.nocoder.microservice.application.dto.BookDto;
import org.nocoder.microservice.application.exception.BookServiceException;
import org.nocoder.microservice.application.service.BookService;
import org.nocoder.microservice.domain.modal.Book;
import org.nocoder.microservice.domain.repository.BookRepository;
import org.nocoder.microservice.domain.service.BookFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * BookServiceImpl
 *
 * @author yangjinlong
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookFactory bookFactory;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookAssembler bookAssembler;

    @Override
    public int addBook(BookDto bookDto) throws BookServiceException {
        try {
            // 1.使用 BookFactory 创建 domain 对象
            Book book = bookFactory.createBook(bookDto.getName());
            // 2.使用 mybatis 进行数据持久化操作
            bookRepository.addBook(book);
        } catch (Exception e) {
            throw new BookServiceException(e.getMessage());
        }
        return 1;
    }


    @Override
    public BookDto getBookById(long id) throws BookServiceException {
        // 参数校验
        Validate.isTrue(id > 0);
        // 查询数据
        Book book = bookRepository.getById(id);
        // 组装DTO
        return bookAssembler.convertToBookDto(book);
    }
}
