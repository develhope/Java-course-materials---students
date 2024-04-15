package com.example.demoweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping(path = "/ciao/{id}")
    public UserName greet(
            @PathVariable long id,
            @RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "cognome", required = false, defaultValue = "") String cognome
    ) {
        logger.info("GET /v1/ciao/{id}");
        logger.debug("params: name = " + nome + ", cognome = " + cognome);
        logger.e

        return new UserName(id, nome, cognome);
    }
}
