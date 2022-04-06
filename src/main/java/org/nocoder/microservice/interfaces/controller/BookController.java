package org.nocoder.microservice.interfaces.controller;

import org.apache.commons.lang.Validate;
import org.nocoder.microservice.application.dto.BookDto;
import org.nocoder.microservice.application.exception.BookServiceException;
import org.nocoder.microservice.application.service.BookService;
import org.nocoder.microservice.infrastructure.BaseResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * book controller
 * @author YangJinlong
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/hello")
    public String hello() {
        return "hello, book service!";
    }

    @PutMapping("/add")
    public String addBook() {

        try {
            BookDto dto = new BookDto();
            dto.setName("test book");
            bookService.addBook(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "add book";
    }

    @GetMapping("/book/{id}")
    public BaseResponse<BookDto> getBookById(@PathVariable("id") long id) throws BookServiceException {
        Validate.isTrue(id > 0);
        return new BaseResponse<BookDto>(bookService.getBookById(id));
    }
}
