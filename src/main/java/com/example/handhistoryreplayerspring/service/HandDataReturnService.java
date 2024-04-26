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
            List<Action> actionsByHand = this.handService.findActionsByHand(hand);
            for (Action dto : actionsByHand) {
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

    private HandDataDto createDtoFromHand(Hand hand) {
        HandDataDto resultDto = new HandDataDto();
        resultDto.setId(hand.getId());
        resultDto.setFirstImgSource(hand.getCards().get(0));
        resultDto.setSecondImgSource(hand.getCards().get(1));
        for (Player player : hand.getPlayers()) {
            if(player.getPlayerName().equals("ZombiChicken")) {
                addPlayerDataToDto(player, resultDto);
            }
        }
        resultDto.setActions(hand.getActions());
        return resultDto;
    }

    private void addPlayerDataToDto(Player player, HandDataDto resultDto) {
        resultDto.setActualPosition(player.getNameOfPosition());
        resultDto.setChipsInBigBlind(player.getChipsInBigBlind());
//        resultDto.setPlayerAction(player.);
    }
}
