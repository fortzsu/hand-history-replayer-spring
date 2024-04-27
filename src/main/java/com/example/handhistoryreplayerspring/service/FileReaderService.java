package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.dto.HandDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileReaderService {

    private final HandService handService;
    private Integer counter = 0;

    @Autowired
    public FileReaderService(HandService handService) {
        this.handService = handService;
    }

    public void readFromFile() throws IOException {
        List<String> lines = new ArrayList<>();
        if(this.counter.equals(0)) {
            Path path = Paths.get("src/main/resources/file.txt");
            lines = Files.readAllLines(path);
            this.counter++;
        }
        findOriginalDataBlocks(lines);
    }

    private void findOriginalDataBlocks(List<String> lines) {
        Map<Integer, List<String>> originalDataBlocks = new HashMap<>();
        int counter = 0;
        for (String line : lines) {
            List<String> blockLines = new ArrayList<>();
            if (line.contains("PokerStars Hand")) {
                counter++;
                blockLines.add(line);
                originalDataBlocks.put(counter, blockLines);
            } else {
                originalDataBlocks.get(counter).add(line);
            }
        }
        fillHands(originalDataBlocks);
    }

    private void fillHands(Map<Integer, List<String>> originalDataBlocks) {
        for (Map.Entry<Integer, List<String>> entry : originalDataBlocks.entrySet()) {
            fillHands(entry.getKey(), entry.getValue());
        }
    }

    public void fillHands(Integer id, List<String> originalLines) {
        this.handService.saveHand(originalLines, id);
    }


}
