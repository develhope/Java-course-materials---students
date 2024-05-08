package com.example.dbqueries;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByName(String name);

    List<BookEntity> findByEditor(String editor);

    List<BookEntity> findByNameStartingWith(String name);

    List<BookEntity> findByNameContaining(String name);

    List<BookEntity> findByNameAndEditor(String name, String editor);

    List<BookEntity> findByNameOrEditor(String name, String editor);

    List<BookEntity> findByNameStartingWithOrderByNameDesc(String name);

}
