package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.dto.HandDataDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HandDataReturnService {

    private final HandService handService;

    public HandDataReturnService(HandService handService) {
        this.handService = handService;
    }

    public List<HandDataDto> getDataFromHand() {
        List<Hand> hands = this.handService.findAll();
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
        return new ArrayList<>();
    }
}
