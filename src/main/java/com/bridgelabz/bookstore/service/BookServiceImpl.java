package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.repository.IBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param id
     * @return Book search by book id
     */
    @Override
    public List<Book> getBookById(Long[] id) {
        return bookRepository.findAllById(Arrays.asList(id));
    }

    /**
     * @param sort
     * @return Book list by sorting it by book price or book quantity
     */
    @Override
    public List<Book> getBookBySortAndSearch(String filter, String sort) throws BookStoreException {
        List<Book> bookList = null;
        switch (sort) {
            case "increasing":
                bookList = bookRepository.findBooksByBookAuthorContainsOrBookTitleContainsOrderByBookPrice(filter, filter);
                break;
            case "decreasing":
                bookList = bookRepository.findBooksByBookAuthorContainsOrBookTitleContainsOrderByBookPriceDesc(filter, filter);
                break;
            case "newlyArrived":
                bookList = bookRepository.findBooksByBookAuthorContainsOrBookTitleContainsOrderByBookQuantity(filter, filter);
                break;
            default:
                bookList = bookRepository.findBooksByBookAuthorContainsOrBookTitleContainsOrderByBookId(filter, filter);
        }
        if (bookList.isEmpty())
            throw new BookStoreException(BookStoreException.ExceptionType.BOOK_IS_NOT_AVAILABLE, "BOOK_IS_NOT_AVAILABLE");
        return bookList;
    }

    @Override
    public Book addBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        return bookRepository.save(book);
    }
}

