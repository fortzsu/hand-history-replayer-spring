package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.domain.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PositionGeneratorService {

    public void findPosition(List<Player> players, List<Position> defaultPositions,
                                             Integer currentButton) {
        Map<Integer, String> orderOfCurrentPositions = new HashMap<>();
        if (players.size() == 2) {
            addPositionWhenThereAreTwoPlayers(orderOfCurrentPositions, currentButton, players);
        } else {
            addPositionWhenThereAreMorePlayers(orderOfCurrentPositions, currentButton, defaultPositions, players);
        }
        for (Player player : players) {
            player.setNameOfPosition(orderOfCurrentPositions.get(player.getSeatNumber()));
        }

    }


    private void addPositionWhenThereAreMorePlayers(Map<Integer, String> orderOfCurrentPositions, Integer currentButton,
                                                           List<Position> defaultPositions, List<Player> players) throws NegativeArraySizeException{
        List<Integer> current = fillCurrentPlayersList(players);
        int currentButtonIndex = current.indexOf(currentButton);
        int defaultButtonIndex = 6;
        if(currentButtonIndex > -1) {
            for (int i = 0, j = defaultButtonIndex, k = currentButtonIndex; i < current.size(); i++) {
                k++;
                if (k == current.size()) {
                    k = 0;
                }
                j++;
                if (j == defaultPositions.size()) {
                    j = defaultPositions.size() - current.size();
                }
                orderOfCurrentPositions.put(current.get(k), String.valueOf(defaultPositions.get(j)));
            }
        } else {
            throw new NegativeArraySizeException();
        }
    }

    private void addPositionWhenThereAreTwoPlayers(Map<Integer, String> orderOfCurrentPositions,
                                                          Integer currentButton, List<Player> players) {
        List<Integer> current = fillCurrentPlayersList(players);
        for (Integer integer : current) {
            if (integer.equals(currentButton)) {
                orderOfCurrentPositions.put(integer, "BU&SB");
            } else {
                orderOfCurrentPositions.put(integer, "BB");
            }
        }
    }

    private List<Integer> fillCurrentPlayersList(List<Player> players) {
        List<Integer> resultList = new ArrayList<>();
        for (Player player : players) {
            resultList.add(player.getSeatNumber());
        }
        return resultList;
    }




}
