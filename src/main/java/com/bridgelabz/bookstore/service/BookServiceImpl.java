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
     * @param id - Book ids list
     * @return Book list by book id
     */
    @Override
    public List<Book> getBookById(Long[] id) {
        return bookRepository.findAllById(Arrays.asList(id));
    }

    /**
     * @param sort - String given by user with search filter
     * @return Book list by sorting it by book price , book newly arrived with search filter
     */
    @Override
    public List<Book> getBookBySortAndSearch(String filter, String sort) throws BookStoreException {
        List<Book> bookList = null;
        switch (sort) {
            case "increasing":
                bookList = bookRepository.findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookPrice(filter, filter);
                break;
            case "decreasing":
                bookList = bookRepository.findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookPriceDesc(filter, filter);
                break;
            case "newlyArrived":
                bookList = bookRepository.findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookQuantity(filter, filter);
                break;
            default:
                bookList = bookRepository.findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookId(filter, filter);
        }
        if (bookList.isEmpty())
            throw new BookStoreException(BookStoreException.ExceptionType.BOOK_IS_NOT_AVAILABLE, "BOOK_IS_NOT_AVAILABLE");
        return bookList;
    }

    /**
     * @param bookDto - New book details given by admin
     * @return New book add to list
     */
    @Override
    public Book addBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        return bookRepository.save(book);
    }
}

