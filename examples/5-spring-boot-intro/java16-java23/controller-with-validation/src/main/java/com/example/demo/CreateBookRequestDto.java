package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

public class CreateBookRequestDto {

    @NotEmpty
    @Size(min = 25)
    @Schema(description = "Book description", name = "description", type = "string", example = "Best book description ever!")
    String description;

    public String getDescription() {
        return description;
    }

    @Email
    @Nullable
    @Schema(description = "Email", name = "email", type = "email", example = "Email")
    String email;

    public String getEmail() {
        return email;
    }

    @NotNull
    @Positive
    @Schema(description = "Book id", name = "id", type = "long", example = "Book id")
    Long id;

    public Long getId() {
        return id;
    }

    @NotEmpty
    @Size(min = 5)
    @Schema(description = "Book name", name = "name", type = "string", example = "Best book name ever!")
    String name;

    public String getName() {
        return name;
    }
}
