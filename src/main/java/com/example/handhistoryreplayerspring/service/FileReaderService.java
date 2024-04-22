package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
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

    @Autowired
    public FileReaderService(HandService handService) {
        this.handService = handService;
    }

    public List<Hand> readFromFile() throws IOException {
        Path path = Paths.get("C:\\Users\\Zsuzsi\\Desktop\\Idea\\hand-history-replayer-spring\\src\\main\\resources\\file.txt");
        List<String> lines = Files.readAllLines(path);
        List<Hand> hands = findOriginalDataBlocks(lines);
        for (Hand hand : hands) {
            System.out.println(hand.getId());
//            System.out.println(hand.getCurrentButton());
//            System.out.println(hand.getCards());
            List<Action> actionsByPlayer = this.handService.findActionsByPlayer(hand);
            for (Action dto : actionsByPlayer) {
                System.out.println(dto.getPlayer().getPlayerName() + " - " + dto.getAction());
            }
            for (Player player : hand.getPlayers()) {
                System.out.println(player.getPlayerName() + " : " + player.getNameOfPosition());
//                System.out.println(player.getSeatNumber());
//                System.out.println(player.getNameOfPosition());
            }
            System.out.println("**************************************************");
        }
        return hands;
    }

    private List<Hand> findOriginalDataBlocks(List<String> lines) {
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
        return fillHands(originalDataBlocks);
    }

    private List<Hand> fillHands(Map<Integer, List<String>> originalDataBlocks) {
        List<Hand> hands = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : originalDataBlocks.entrySet()) {
            hands.add(fillHands(entry.getKey(), entry.getValue()));
        }
        return hands;
    }

    public Hand fillHands(Integer id, List<String> originalLines) {
        return this.handService.saveHand(originalLines, id);
    }
}
