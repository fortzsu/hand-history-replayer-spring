package com.example.handhistoryreplayerspring.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Hand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Double bigBlind;
    @Column
    private Integer currentButton;
    @Column
    private final List<String> cards = new ArrayList<>();
    @Column
    @OneToMany
    private List<Player> players = new ArrayList<>();
    @Column
    @OneToMany
    private List<Action> actions = new ArrayList<>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBigBlind() {
        return bigBlind;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setBigBlind(Double bigBlind) {
        this.bigBlind = bigBlind;
    }

    public Integer getCurrentButton() {
        return currentButton;
    }

    public void setCurrentButton(Integer currentButton) {
        this.currentButton = currentButton;
    }

    public List<String> getCards() {
        return cards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addCard(String card) {
        this.cards.add(card);
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
