package com.example.demoweb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @GetMapping(path = "/ciao/{id}")
    public UserName greet(
            @PathVariable long id,
            @RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "cognome", required = false, defaultValue = "") String cognome
    ) {
        return new UserName(id, nome, cognome);
    }
}
