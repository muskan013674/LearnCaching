package com.example.demo.controller;

import com.example.demo.BookService;
import com.example.demo.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book); }

        @PutMapping(value = "/book")
    public Book updateBook(@RequestBody Book book){return bookService.updateBook(book);}

    @GetMapping(value = "/book/{id}")
    public Book getBook(@PathVariable int id){return bookService.getBook(id);}

    @DeleteMapping(value  = "/book/{id}")
    public String deleteBook(@PathVariable int id ) {return bookService.deleteBook(id);}
}
