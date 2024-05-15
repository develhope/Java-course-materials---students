package com.example.entityrelationships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/all")
    public Iterable<StudentEntity> getAllStudents() {
        //TODO
        return new ArrayList<>();
    }

}
