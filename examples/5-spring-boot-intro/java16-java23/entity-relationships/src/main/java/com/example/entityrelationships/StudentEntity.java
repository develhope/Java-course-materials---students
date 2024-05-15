package com.example.entityrelationships;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class StudentEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;


    private StudentEntity() {}

    public StudentEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
