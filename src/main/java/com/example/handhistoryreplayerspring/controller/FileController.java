package com.example.handhistoryreplayerspring.controller;

import com.example.handhistoryreplayerspring.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileReaderService fileReaderService;

    @Autowired
    public FileController(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    @GetMapping("")
    public void getFile() throws IOException {
        this.fileReaderService.readFromFile();
    }
}
