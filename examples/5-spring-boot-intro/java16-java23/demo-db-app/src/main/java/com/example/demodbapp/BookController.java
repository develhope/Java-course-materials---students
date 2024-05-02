package com.example.demodbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/all")
    public Iterable<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("")
    public BookEntity getBook() {
        BookEntity newBook = new BookEntity("The Bible", "Mondadori", "ljfdsljhkdf", BookStatus.COME_NUOVO, BookType.LIBRO);
        bookRepository.save(newBook);
        return newBook;
    }

}
