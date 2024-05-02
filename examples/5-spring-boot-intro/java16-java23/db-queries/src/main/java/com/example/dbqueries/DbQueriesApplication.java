package com.example.dbqueries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbQueriesApplication implements ApplicationRunner {

    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(DbQueriesApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initDb();
    }

    public void initDb() {
        BookEntity newBook1 = new BookEntity("The Bible", "Mondadori", "ljfdsljhkd1", BookStatus.COME_NUOVO, BookType.LIBRO);
        bookRepository.save(newBook1);

        BookEntity newBook2 = new BookEntity("The Bible", "Feltrinelli", "ljfdsljhkd2", BookStatus.NUOVO, BookType.LIBRO);
        bookRepository.save(newBook2);

        BookEntity newBook3 = new BookEntity("Harry Potter 1", "Mondadori", "ljfdsljhkd3", BookStatus.COME_NUOVO, BookType.LIBRO);
        bookRepository.save(newBook3);

        BookEntity newBook4 = new BookEntity("Harry Potter 2", "Mondadori", "ljfdsljhkd4", BookStatus.COME_NUOVO, BookType.LIBRO);
        bookRepository.save(newBook4);

        BookEntity newBook5 = new BookEntity("Introduzione a Java Spring", "Selerio", "ljfdsljhkd5", BookStatus.NUOVO, BookType.RIVISTA);
        bookRepository.save(newBook5);
    }
}
