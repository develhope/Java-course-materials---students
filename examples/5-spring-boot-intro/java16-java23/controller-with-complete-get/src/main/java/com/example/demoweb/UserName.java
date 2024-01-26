package com.example.demoweb;

import jakarta.validation.constraints.NotNull;

public class UserName {

    public UserName(long id, String nome, String cognome) {
        this.id = id;
        this.name = nome;
        this.cognome = cognome;
    }

    @NotNull public long id;

    @NotNull public String name;

    @NotNull public String cognome;
}
