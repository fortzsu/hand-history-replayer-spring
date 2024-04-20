package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Player savePlayer(Integer seatNumber, String playerName, Double chipCount, Hand hand) {
        this.playerRepository.save(player);

        Player tempPlayer = null;
        if (checkIfPlayersPositionIsTaken(seatNumber)) {
            tempPlayer = new Player(seatNumber, playerName);
            this.players.add(tempPlayer);
            player.setHand(hand);
            setChipCount(tempPlayer, chipCount);
        }
        return tempPlayer;
        return player;
    }

    public Player addNewPlayer() {

    }

    private void fillPlayers(List<String> originalLines, Hand hand) {
        for (String originalLine : originalLines) {
            if (originalLine.contains("Seat") && originalLine.contains("chips")) {
                setPlayerFields(originalLine, hand);
            }
        }
    }

    private Player setPlayerFields(String originalDataLines, Hand hand) {
        int index = originalDataLines.indexOf(":");
        String number = originalDataLines.substring(index - 1, index);
        Integer seat = Integer.parseInt(number);
        int playerIndex = originalDataLines.indexOf(" ", index + 2);
        String player = originalDataLines.substring(index + 2, playerIndex);
        String betweenParenthesis = originalDataLines.substring(originalDataLines.indexOf("("), originalDataLines.indexOf(")") + 1);
        double chipCount = Double.parseDouble(betweenParenthesis.substring(1, betweenParenthesis.indexOf(" ")));
        return hand.addNewPlayer(seat, player, chipCount);
    }






}
