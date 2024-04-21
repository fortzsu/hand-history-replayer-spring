package com.example.handhistoryreplayerspring.controller;

import com.example.handhistoryreplayerspring.service.HandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final HandService handService;

    @Autowired
    public FileController(HandService handService) {
        this.handService = handService;
    }

    @GetMapping("")
    public void getFile() {
        System.out.println(this.handService.saveHand(new ArrayList<>()));
    }
}
