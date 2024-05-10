package com.example.dbqueries;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByName(String name);

    List<BookEntity> findByEditor(String editor);

    List<BookEntity> findByNameStartingWith(String name);

    List<BookEntity> findByNameContaining(String name, Pageable pageable);

    List<BookEntity> findByNameAndEditor(String name, String editor);

    List<BookEntity> findByNameOrEditor(String name, String editor);

    List<BookEntity> findByNameStartingWithOrderByNameDesc(String name);

    List<BookEntity> deleteByName(String name);

    @Query("select b from BookEntity b where b.type = ?1")
    List<BookEntity> findByType(BookType type);

    @Query(value = "SELECT * FROM book b WHERE b.status = ?1", nativeQuery = true)
    List<BookEntity> findByStatus(BookStatus status);
}
