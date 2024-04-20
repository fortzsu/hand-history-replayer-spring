package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.repository.ActionRepository;
import com.example.handhistoryreplayerspring.repository.HandRepository;
import com.example.handhistoryreplayerspring.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandService {

    private final PlayerRepository playerRepository;
    private final HandRepository handRepository;
    private final ActionRepository actionRepository;

    @Autowired
    public HandService(PlayerRepository playerRepository, HandRepository handRepository,
                       ActionRepository actionRepository) {
        this.playerRepository = playerRepository;
        this.handRepository = handRepository;
        this.actionRepository = actionRepository;
    }

    public Integer saveHand() {
        Hand hand = new Hand();
        this.handRepository.save(hand);
        Player player = new Player();
        player.setHand(hand);
        this.playerRepository.save(player);

        Action action = new Action();
        action.setPlayer(player);
        this.actionRepository.save(action);

        return this.handRepository.findAll().size();
    }

}
