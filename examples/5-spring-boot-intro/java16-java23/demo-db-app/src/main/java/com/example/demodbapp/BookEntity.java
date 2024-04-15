package com.example.demodbapp;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class BookEntity {

    @Id
    @GeneratedValue
    @Column(name="my_id")
    private Long id;

    public Long getId() {
        return id;
    }
}
