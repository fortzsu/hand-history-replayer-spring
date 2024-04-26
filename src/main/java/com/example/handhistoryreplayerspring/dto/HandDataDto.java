package com.example.handhistoryreplayerspring.dto;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;

import java.util.List;

public class HandDataDto {
    private Integer id;
    private String firstImgSource;
    private String secondImgSource;
    private String chipsInBigBlind;
    private String playerAction;
    private String actualPosition;
    private List<Action> actions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstImgSource() {
        return firstImgSource;
    }

    public String getSecondImgSource() {
        return secondImgSource;
    }

    public String getChipsInBigBlind() {
        return chipsInBigBlind;
    }

    public String getPlayerAction() {
        return playerAction;
    }

    public String getActualPosition() {
        return actualPosition;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setFirstImgSource(String firstImgSource) {
        this.firstImgSource = firstImgSource;
    }

    public void setSecondImgSource(String secondImgSource) {
        this.secondImgSource = secondImgSource;
    }

    public void setChipsInBigBlind(String chipsInBigBlind) {
        this.chipsInBigBlind = chipsInBigBlind;
    }

    public void setPlayerAction(String playerAction) {
        this.playerAction = playerAction;
    }

    public void setActualPosition(String actualPosition) {
        this.actualPosition = actualPosition;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
