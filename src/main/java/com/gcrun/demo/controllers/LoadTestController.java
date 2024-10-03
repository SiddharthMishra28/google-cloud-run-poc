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

@Controller
public class LoadTestController {

    @GetMapping("/loaderio-1d3b4ed9ec53cc97e4767fdb8309cb02")
    public ResponseEntity<FileSystemResource> downloadTextFile() {
        // Specify the path to your text file
        File file = new File("loaderio-1d3b4ed9ec53cc97e4767fdb8309cb02.txt");

        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Create the response entity
        FileSystemResource resource = new FileSystemResource(file);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.TEXT_PLAIN)
                .body(resource);
    }
}
