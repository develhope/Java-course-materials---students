package com.example.dbqueries;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="book")
public class BookEntity {

    @Id
    @GeneratedValue
    @Column(name="my_id")
    private Long id;

    @Column(name="editor")
    private String editor;

    @Column(name="isbn", length = 13, unique = true)
    @NotNull
    private String isbn;

    @Column(name="name")
    private String name;

    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    private BookStatus status;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private BookType type;

    private BookEntity() {}

    public BookEntity(String name, String editor, String isbn, BookStatus status, BookType type) {
        this.name = name;
        this.editor = editor;
        this.isbn = isbn;
        this.status = status;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }
}
