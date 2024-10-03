package com.gcrun.demo.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class LoadTestController {

    @GetMapping("/loaderio-1d3b4ed9ec53cc97e4767fdb8309cb02/")
    public ResponseEntity<String> getTextFileContent() {
        // Specify the path to your text file
        Path filePath = Paths.get("loaderio-1d3b4ed9ec53cc97e4767fdb8309cb02.txt");

        try {
            // Read the content of the file
            String content = Files.readString(filePath);
            return ResponseEntity.ok()
                    .contentType(org.springframework.http.MediaType.TEXT_PLAIN)
                    .body(content);
        } catch (IOException e) {
            // Handle the case where the file does not exist or cannot be read
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
        }
    }
}
