package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * @param ids
     * @return Book details according to book id
     */
    @GetMapping("/get-books-by-id")
    public ResponseEntity<List<Book>> getBookById(@RequestParam(value = "ids") Long[] ids) {
        return new ResponseEntity<>(bookService.getBookById(ids), HttpStatus.OK);
    }

    /**
     * @param sort String Given By User
     * @return Book list by sorting price
     */
    @GetMapping("/sorted/{sort}/{filter}")
    public ResponseEntity<List<Book>> getBookBySortAndSearch(@PathVariable(value = "sort") String sort
            , @PathVariable String filter) {
        try {
            return new ResponseEntity<>(bookService.getBookBySortAndSearch(filter, sort), HttpStatus.OK);
        } catch (BookStoreException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sorted/{sort}")
    public ResponseEntity<List<Book>> getBookBySort(@PathVariable(value = "sort") String sort) {
        try {
            return new ResponseEntity<>(bookService.getBookBySortAndSearch("", sort), HttpStatus.OK);
        } catch (BookStoreException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) {
        Book book = bookService.addBook(bookDto);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
