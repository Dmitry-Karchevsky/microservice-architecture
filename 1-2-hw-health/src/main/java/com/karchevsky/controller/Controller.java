package com.karchevsky.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/health",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().body("{\"status\": \"OK\"}");
    }

}
