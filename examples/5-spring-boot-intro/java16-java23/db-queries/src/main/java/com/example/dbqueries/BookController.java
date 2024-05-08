package com.example.dbqueries;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public List<BookEntity> getBooks(@Nullable @RequestParam String name, @Nullable @RequestParam String editor) {
        if (name != null && !name.isBlank() && editor != null && !editor.isBlank()) {
            return bookRepository.findByNameOrEditor(name, editor);
        } else if (name != null && !name.isBlank()) {
            return bookRepository.findByNameStartingWithOrderByNameDesc(name);
        } else if (editor != null && !editor.isBlank()) {
            return bookRepository.findByEditor(editor);
        } else {
            return new ArrayList<>();
        }
    }

}
