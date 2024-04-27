package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.dto.HandDataDto;
import com.example.handhistoryreplayerspring.repository.ActionRepository;
import com.example.handhistoryreplayerspring.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HandDataReturnService {

    private final HandService handService;
    private final PlayerRepository playerRepository;
    private final ActionRepository actionRepository;

    public HandDataReturnService(HandService handService, PlayerRepository playerRepository, ActionRepository actionRepository) {
        this.handService = handService;
        this.playerRepository = playerRepository;
        this.actionRepository = actionRepository;
    }

    public List<HandDataDto> getDataFromHand() {
        List<HandDataDto> dtoList = new ArrayList<>();
        List<Hand> hands = this.handService.findAll();
        for (Hand hand : hands) {
            List<Player> players = this.playerRepository.findPlayersByHand(hand);
            List<Action> actions = this.actionRepository.findAllByHand(hand);
            HandDataDto temp = createDtoFromHand(hand, players, actions);
            dtoList.add(temp);
        }
//        for (HandDataDto dto : dtoList) {
//            System.out.println(dto.getId());
//            System.out.println(dto.getFirstImgSource());
//            System.out.println(dto.getSecondImgSource());
//            System.out.println(dto.getPlayerAction());
//            System.out.println(dto.getActualPosition());
//            System.out.println(dto.getChipsInBigBlind());
//            for (Action action : dto.getActions()) {
//                System.out.println(action);
//            }
//            System.out.println("***********************************");
//        }
        return dtoList;
    }

    private HandDataDto createDtoFromHand(Hand hand, List<Player> players, List<Action> actions) {
        HandDataDto resultDto = new HandDataDto();
        resultDto.setId(hand.getId());
        resultDto.setFirstImgSource(hand.getCards().get(0));
        resultDto.setSecondImgSource(hand.getCards().get(1));
        for (Player player : players) {
            if (player.getPlayerName().equals("ZombiChicken")) {
                addPlayerDataToDto(player, resultDto);
            }
        }
        List<String> actionString = new ArrayList<>();
        for (Action action : actions) {
            actionString.add(action.getPlayer().getPlayerName() + " - " + action.getAction());
        }
        resultDto.setActions(actionString);
        return resultDto;
    }

    private void addPlayerDataToDto(Player player, HandDataDto resultDto) {
        resultDto.setActualPosition(player.getNameOfPosition());
        resultDto.setChipsInBigBlind(player.getChipsInBigBlind());
    }
}
