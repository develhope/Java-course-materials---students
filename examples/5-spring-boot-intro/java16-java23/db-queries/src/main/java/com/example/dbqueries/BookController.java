package com.example.dbqueries;

import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Transactional
    @GetMapping("/delete")
    public Iterable<BookEntity> deleteBooks(@Nullable @RequestParam String name) {
        bookRepository.deleteByName(name);
        return bookRepository.findAll();
    }

    @GetMapping("/paginated")
    public List<BookEntity> getPaginatedBooks(@Nullable @RequestParam String name,
                                              @RequestParam int page,
                                              @RequestParam int length,
                                              @RequestParam boolean ascending) {

        Sort sorting = ascending ? Sort.by("name") : Sort.by("name").descending();

        if (name != null && !name.isBlank()) {
            return bookRepository.findByNameContaining(name, PageRequest.of(page, length, sorting));
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/all")
    public Iterable<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("")
    public List<BookEntity> getBooks(@Nullable @RequestParam String name, @Nullable @RequestParam String editor) {
        if (name != null && !name.isBlank() && editor != null && !editor.isBlank()) {
            return bookRepository.findByNameOrEditor(name, editor);
        } else if (name != null && !name.isBlank()) {
            return bookRepository.findByName(name);
        } else if (editor != null && !editor.isBlank()) {
            return bookRepository.findByEditor(editor);
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/type")
    public List<BookEntity> getBooksByType(@RequestParam BookType type) {
        return bookRepository.findByType(type);
    }

    @GetMapping("/status")
    public List<BookEntity> getBooksByStatus(@RequestParam BookStatus status) {
        return bookRepository.findByStatus(status);
    }
}
