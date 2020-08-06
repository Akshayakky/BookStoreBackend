package com.bridgelabz.bookstore;

import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.repository.IBookRepository;
import com.bridgelabz.bookstore.repository.ICartRepository;
import com.bridgelabz.bookstore.service.IBookService;
import com.bridgelabz.bookstore.service.ICartService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {

    @MockBean
    IBookRepository bookRepository;

    @MockBean
    ICartRepository cartRepository;

    @Autowired
    IBookService bookService;

    @Autowired
    ICartService cartService;

    @Autowired
    ModelMapper modelMapper;

    @Test
    void getBookById() {
        Long[] IDs = {1L, 3L};
        when(bookRepository.findAllById(Arrays.asList(IDs))).thenReturn(Stream.of(new Book("Chetan Bhagat"
                        , "The Girl in Room 105"
                        , "http://books.google.com/books/content?id=GHt_uwEACAAJ&printsec=frontcover&img=1&zoom=5"
                        , 12, 193.0
                        , "Hi I'm Keshavand my life is screwed. I hate my job and my girlfriend left me.")
                , new Book("Rujuta Divekar", "Indian Superfoods"
                        , "http://books.google.com/books/content?id=4oFoDwAAQBAJ&printsec=frontcover&img=1&zoom=5"
                        , 13, 495.0, "Forget about acacia seeds and goji berries. " +
                        "The secret foods for healthvitality and weight loss lie in our own kitchens and backyards.")
                ).collect(Collectors.toList())
        );
        List<Book> books = bookService.getBookById(IDs);
        Assert.assertEquals(2, books.size());
    }

    @Test
    void getBookByDefaultSortAndEmptySearch() throws BookStoreException {
        String search = "";
        when(bookRepository.findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookId(search, search)).thenReturn(Stream.of(new Book("Chetan Bhagat"
                        , "The Girl in Room 105"
                        , "http://books.google.com/books/content?id=GHt_uwEACAAJ&printsec=frontcover&img=1&zoom=5"
                        , 12, 193.0
                        , "Hi I'm Keshavand my life is screwed. I hate my job and my girlfriend left me.")
                , new Book("Rujuta Divekar", "Indian Superfoods"
                        , "http://books.google.com/books/content?id=4oFoDwAAQBAJ&printsec=frontcover&img=1&zoom=5"
                        , 13, 495.0, "Forget about acacia seeds and goji berries. " +
                        "The secret foods for healthvitality and weight loss lie in our own kitchens and backyards.")
                ).collect(Collectors.toList())
        );
        List<Book> books = bookService.getBookBySortAndSearch(search, "default");
        Assert.assertEquals(2, books.size());
    }

    @Test
    void getBookByDefaultSortAndSearchString() throws BookStoreException {
        String search = "chetan";
        when(bookRepository.findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookId(search, search)).thenReturn(Stream.of(new Book("Chetan Bhagat"
                        , "The Girl in Room 105"
                        , "http://books.google.com/books/content?id=GHt_uwEACAAJ&printsec=frontcover&img=1&zoom=5"
                        , 12, 193.0
                        , "Hi I'm Keshavand my life is screwed. I hate my job and my girlfriend left me.")
                ).collect(Collectors.toList())
        );
        List<Book> books = bookService.getBookBySortAndSearch(search, "default");
        Assert.assertEquals("Chetan Bhagat", books.get(0).getBookAuthor());
    }

    @Test
    void getBookByDecreasingPriceSortAndSearchString() throws BookStoreException {
        String search = "chetan";
        when(bookRepository.findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookId(search, search)).thenReturn(Stream.of(new Book("Chetan Bhagat"
                        , "The Girl in Room 105 Hardcover"
                        , "http://books.google.com/books/content?id=GHt_uwEACAAJ&printsec=frontcover&img=1&zoom=5"
                        , 12, 193.0
                        , "Hi I'm Keshavand my life is screwed. I hate my job and my girlfriend left me.")
                , new Book("Chetan Bhagat"
                        , "The Girl in Room 105"
                        , "http://books.google.com/books/content?id=GHt_uwEACAAJ&printsec=frontcover&img=1&zoom=5"
                        , 12, 150
                        , "Hi I'm Keshavand my life is screwed. I hate my job and my girlfriend left me.")
                ).collect(Collectors.toList())
        );
        List<Book> books = bookService.getBookBySortAndSearch(search, "default");
        Assert.assertEquals(2, books.size());
    }

    @Test
    void getBookByIncreasingPriceSortAndSearchString() throws BookStoreException {
        String search = "chetan";
        when(bookRepository.findBooksByBookAuthorContainsIgnoreCaseOrBookTitleContainsIgnoreCaseOrderByBookId(search, search)).thenReturn(Stream.of(new Book("Chetan Bhagat"
                        , "The Girl in Room 105"
                        , "http://books.google.com/books/content?id=GHt_uwEACAAJ&printsec=frontcover&img=1&zoom=5"
                        , 12, 150
                        , "Hi I'm Keshavand my life is screwed. I hate my job and my girlfriend left me.")
                , new Book("Chetan Bhagat"
                        , "The Girl in Room 105 Hardcover"
                        , "http://books.google.com/books/content?id=GHt_uwEACAAJ&printsec=frontcover&img=1&zoom=5"
                        , 12, 193.0
                        , "Hi I'm Keshavand my life is screwed. I hate my job and my girlfriend left me.")
                ).collect(Collectors.toList())
        );
        List<Book> books = bookService.getBookBySortAndSearch(search, "default");
        Assert.assertEquals(2, books.size());
    }
}
