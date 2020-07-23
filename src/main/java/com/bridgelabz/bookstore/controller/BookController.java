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
     * @param ids - Book ids list
     * @return Book details according to book id
     */
    @GetMapping("/get-books-by-id")
    public ResponseEntity<List<Book>> getBookById(@RequestParam(value = "ids") Long[] ids) {
        return new ResponseEntity<>(bookService.getBookById(ids), HttpStatus.OK);
    }

    /**
     * @param sort - String given by user with search filter
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

    /**
     * @param sort - String given by user without search filter
     * @return Book list by sorting price
     */
    @GetMapping("/sorted/{sort}")
    public ResponseEntity<List<Book>> getBookBySort(@PathVariable(value = "sort") String sort) {
        try {
            return new ResponseEntity<>(bookService.getBookBySortAndSearch("", sort), HttpStatus.OK);
        } catch (BookStoreException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @param bookDto - New book details
     * @return New book add to list
     */
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) {
        Book book = bookService.addBook(bookDto);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    /**
     * @param bookId - Book Id Of book to be removed
     * @return Removed Message
     */
    @DeleteMapping
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.removeBook(bookId);
        return new ResponseEntity<>("Book Removed Successfully", HttpStatus.OK);
    }
}
