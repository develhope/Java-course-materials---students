package com.example.demoweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @RequestMapping(method=GET, path="/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }
}
