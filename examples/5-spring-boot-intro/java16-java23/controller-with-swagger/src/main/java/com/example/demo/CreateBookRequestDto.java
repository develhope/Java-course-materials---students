package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateBookRequestDto {

    @Schema(description = "Book description", name = "description", type = "string", example = "Best book description ever!")
    String description;
    public String getDescription() {
        return description;
    }

    @Schema(description = "Book name", name = "name", type = "string", example = "Best book name ever!")
    String name;

    public String getName() {
        return name;
    }
}
