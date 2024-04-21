package com.example.handhistoryreplayerspring.service;


import com.example.handhistoryreplayerspring.domain.Hand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicHandDataService {

    public void setCurrentButton(String originalDataHands, Hand hand) throws NumberFormatException {
        int index = originalDataHands.indexOf("#");
        String button = originalDataHands.substring(index + 1, index + 2);
        hand.setCurrentButton(Integer.valueOf(button));
    }

    public void setBigBlind(String line, Hand hand) throws NumberFormatException {
        List<String> lineString = List.of(line.split(" "));
        String value = lineString.get(lineString.size() - 1);
        hand.setBigBlind(Double.parseDouble(value));
    }

    public void setCards(String line, Hand hand) {
        hand.addCard(line.substring(line.length() - 6, line.length() - 4));
        hand.addCard(line.substring(line.length() - 3, line.length() - 1));
    }

}
