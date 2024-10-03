package com.gcrun.demo.controllers;

import com.gcrun.demo.models.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<Greeting> greetUser() {
        Greeting greeting = new Greeting();
        greeting.setMessage("Hello there");
        greeting.setName("Sid");
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
