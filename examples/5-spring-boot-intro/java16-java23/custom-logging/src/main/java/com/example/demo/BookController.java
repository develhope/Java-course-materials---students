package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/book")
@Tag(name = "Book", description = "The Book API")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Returns a book by ID", description = "Returns an existing book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
    })
    public ResponseEntity<BookDto> findById(
            @Parameter(name = "id", description = "Book id", example = "123", required = true, in = ParameterIn.PATH)
            @PathVariable
            long id) {

        logger.debug("findById called!");

        return ResponseEntity.ok(new BookDto(id, "Invented name!"));
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Returns a list of books", description = "Returns a list of found books")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = BookDto.class)))})
            })
    public Collection<BookDto> findBooks() {
        return new ArrayList<BookDto>();
    }


    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Creates a book by ID", description = "Returns a created book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New book created!")
    })
    public ResponseEntity<BookDto> createBook(@RequestBody final CreateBookRequestDto request) {
        long id = new Random().nextLong();
        return ResponseEntity.status(HttpStatus.CREATED).body(new BookDto(id, request.name));
    }
}
