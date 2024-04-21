package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.domain.Position;
import com.example.handhistoryreplayerspring.repository.HandRepository;
import com.example.handhistoryreplayerspring.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HandService {

    private final PlayerRepository playerRepository;
    private final HandRepository handRepository;
    private final BasicHandDataService basicHandDataService;
    private final PositionGeneratorService positionGeneratorService;
    private final PlayerService playerService;
    private final ActionService actionService;

    @Autowired
    public HandService(PlayerRepository playerRepository, HandRepository handRepository,
                       BasicHandDataService basicHandDataService,
                       PositionGeneratorService positionGeneratorService, PlayerService playerService, ActionService actionService) {
        this.playerRepository = playerRepository;
        this.handRepository = handRepository;
        this.basicHandDataService = basicHandDataService;
        this.positionGeneratorService = positionGeneratorService;
        this.playerService = playerService;
        this.actionService = actionService;
    }

    public Hand saveHand(List<String> originalLines, Integer id) {
        Hand hand = new Hand();
        hand.setId(id);
        String cards = "";
        for (String originalLine : originalLines) {
            if (originalLine.contains("posts big blind")) {
                this.basicHandDataService.setBigBlind(originalLine, hand);
            }
            if (originalLine.contains("is the button")) {
                this.basicHandDataService.setCurrentButton(originalLine, hand);
            }
            if (originalLine.contains("Dealt to ZombiChicken")) {
                cards = originalLine;
                this.basicHandDataService.setCards(originalLine, hand);
            }
        }

        this.handRepository.save(hand);
        List<Player> players = this.playerService.fillPlayers(originalLines, hand);
        hand.setPlayers(players);
        generatePositionsToPlayersInHand(hand);

        this.actionService.createAction(originalLines, cards, players, hand);


        return hand;
    }


    private void generatePositionsToPlayersInHand(Hand hand) {
        List<Player> players = this.playerRepository.findPlayersByHand(hand);
        Integer currentButton = hand.getCurrentButton();
        List<Position> defaultPositions = Arrays.stream(Position.values()).toList();
        this.positionGeneratorService.findPosition(players, defaultPositions, currentButton);
    }

    public List<Action> findActionsByPlayer(Hand hand) {
        return this.actionService.findActionsByPlayer(hand);
    }

}
