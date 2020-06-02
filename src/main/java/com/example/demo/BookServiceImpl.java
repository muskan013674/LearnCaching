package com.example.demo;

import com.example.demo.dto.Book;
import com.example.demo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        logger.info("adding book with id" , book.getId());
        return bookRepository.save(book);
    }

    @Override
    @CachePut(cacheNames =  "books", key = "#book.id")
    public Book updateBook(Book book) {
        logger.info("book updated with new name");
         bookRepository.updateAddBook(book.getId(), book.getName());
        return book;
    }

    @Override
    @Cacheable(cacheNames =  "books", key = "#id")
    public Book getBook(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())
        return book.get();
        else
            return new Book();
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }
}
