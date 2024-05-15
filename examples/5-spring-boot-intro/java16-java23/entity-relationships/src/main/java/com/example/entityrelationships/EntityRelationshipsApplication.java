package com.example.entityrelationships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntityRelationshipsApplication implements ApplicationRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(EntityRelationshipsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initDb();
    }

    public void initDb() {
        StudentEntity student1 = new StudentEntity("Sasa");
        studentRepository.save(student1);
    }
}
