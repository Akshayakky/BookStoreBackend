package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:3000")
public class OnlineBookController {

    @Autowired
    private IBookService bookService;

    /**
     *
     * @return All books inside database with details
     */
    @GetMapping("/get-books")
    public List<Book> getBooks() {
        return bookService.getBookList();
    }

    /**
     *
     * @param id
     * @return Book details according to book id
     */
    @GetMapping("/get-books-by-id")
    public List<Book> getBookById(@RequestParam(value = "id") Long[] id) {
        return bookService.getBookById(id);
    }

     /**
     *
     * @param filter
     * @return Book by filter search may be it will be author name or book title
     * @throws BookStoreException
     */
    @GetMapping("/get-books/{filter}")
    public List<Book> getBookByFilter(@PathVariable String filter) throws BookStoreException {
        return bookService.getBookByFilter(filter);
    }

    /**
     *
     * @param sort
     * @return Book list by sorting price
     */
    @GetMapping("/sorted/{sort}")
    public List<Book> getBookBySort(@PathVariable(value = "sort") String sort) {
        return bookService.getBookBySort(sort);
    }
}
