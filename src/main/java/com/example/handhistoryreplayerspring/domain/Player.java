package com.example.handhistoryreplayerspring.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer seatNumber;
    @Column
    private String playerName;
    @Column
    private String nameOfPosition;
    @Column
    private Double chipCount;
    @Column
    private String chipsInBigBlind;
    @ManyToOne
    @JoinColumn(name = "hand")
    private Hand hand;
    @Column
    @OneToMany
    private List<Action> actions;

    public Player() {
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getNameOfPosition() {
        return nameOfPosition;
    }

    public void setNameOfPosition(String nameOfPosition) {
        this.nameOfPosition = nameOfPosition;
    }

    public Double getChipCount() {
        return chipCount;
    }

    public void setChipCount(Double chipCount) {
        this.chipCount = chipCount;
    }

    public String getChipsInBigBlind() {
        return chipsInBigBlind;
    }

    public void setChipsInBigBlind(String chipsInBigBlind) {
        this.chipsInBigBlind = chipsInBigBlind;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
