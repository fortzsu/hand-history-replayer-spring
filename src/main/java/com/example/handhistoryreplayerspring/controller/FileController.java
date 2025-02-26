package com.example.handhistoryreplayerspring.controller;

import com.example.handhistoryreplayerspring.dto.HandDataDto;
import com.example.handhistoryreplayerspring.service.FileReaderService;
import com.example.handhistoryreplayerspring.service.FileStorageService;
import com.example.handhistoryreplayerspring.service.HandDataReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file")
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {

    private final FileReaderService fileReaderService;

    private final FileStorageService fileStorageService;

    private final HandDataReturnService handDataReturnService;

    @Autowired
    public FileController(FileReaderService fileReaderService,
                          FileStorageService fileStorageService,
                          HandDataReturnService handDataReturnService) {
        this.fileReaderService = fileReaderService;
        this.fileStorageService = fileStorageService;
        this.handDataReturnService = handDataReturnService;
    }

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/src/main/resources")
                .path(fileName)
                .toUriString();
    }

    @GetMapping("/getData")
    public List<HandDataDto> getDataFromHand() throws IOException {
        this.fileReaderService.readFromFile();
        List<HandDataDto> dtoList = this.handDataReturnService.getDataFromHand();
        if(dtoList.size() != 0) {
            this.fileStorageService.deleteFile();
        }
        return dtoList;
    }


}
