package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class BookDto {
    @Schema(description = "Book id", name = "id", type = "long", example = "123")
    @NotNull
    long id;

    @Schema(description = "Book name", name = "name", type = "string", example = "Best book ever!")
    @NotNull
    String name;

    public BookDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
