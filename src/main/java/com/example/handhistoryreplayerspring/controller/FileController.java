package com.example.handhistoryreplayerspring.controller;

import com.example.handhistoryreplayerspring.service.FileReaderService;
import com.example.handhistoryreplayerspring.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileReaderService fileReaderService;

    private final FileStorageService fileStorageService;

    @Autowired
    public FileController(FileReaderService fileReaderService, FileStorageService fileStorageService) {
        this.fileReaderService = fileReaderService;
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("text") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/resources")
                .path(fileName)
                .toUriString();
    }

    @GetMapping("")
    public void getFile() throws IOException {
        this.fileReaderService.readFromFile();
    }

}
