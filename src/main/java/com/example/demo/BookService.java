package com.example.demo;

import com.example.demo.dto.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book);
    Book getBook(int id);
    String deleteBook(int id);

}
