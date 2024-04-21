package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> fillPlayers(List<String> originalLines, Hand hand) {
        Player temp = new Player();
        List<Player> playerList = new ArrayList<>();
        for (String originalLine : originalLines) {
            if (originalLine.contains("Seat") && originalLine.contains("chips")) {
                temp = setPlayerFields(originalLine, hand);
                playerList.add(temp);
            }
        }
        return playerList;
    }

    private Player setPlayerFields(String originalDataLines, Hand hand) {
        int index = originalDataLines.indexOf(":");
        String number = originalDataLines.substring(index - 1, index);
        Integer seat = Integer.parseInt(number);
        int playerIndex = originalDataLines.indexOf(" ", index + 2);
        String player = originalDataLines.substring(index + 2, playerIndex);
        String betweenParenthesis = originalDataLines.substring(originalDataLines.indexOf("("), originalDataLines.indexOf(")") + 1);
        double chipCount = Double.parseDouble(betweenParenthesis.substring(1, betweenParenthesis.indexOf(" ")));
        return this.savePlayer(hand, seat, player, chipCount);
    }


    public Player savePlayer(Hand hand, Integer seatNumber, String playerName, Double chipCount) {
        Player tempPlayer = null;
        if (checkIfPlayersPositionIsTaken(seatNumber, hand)) {
            tempPlayer = new Player(seatNumber, playerName);
            tempPlayer.setHand(hand);
            setChipCount(tempPlayer, chipCount, hand);
            this.playerRepository.save(tempPlayer);
        }
        return tempPlayer;
    }

    private void setChipCount(Player tempPlayer, Double chipCount, Hand hand) {
        tempPlayer.setChipCount(hand.getBigBlind(), chipCount);
    }

    private boolean checkIfPlayersPositionIsTaken(Integer seatNumber, Hand hand) {
        for (Player player : hand.getPlayers()) {
            if (player.getSeatNumber().equals(seatNumber)) {
                return false;
            }
        }
        return true;
    }





}
