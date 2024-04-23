package com.example.handhistoryreplayerspring.dto;

import java.util.List;

public class HandDataDto {
    private String firstImgSource;
    private String secondImgSource;
    private String chipsInBigBlind;
    private String playerAction;
    private String actualPosition;
    private List<String> actions;

    public HandDataDto(String firstImgSource, String secondImgSource,
                       String chipsInBigBlind, String playerAction,
                       String actualPosition, List<String> actions) {
        this.firstImgSource = firstImgSource;
        this.secondImgSource = secondImgSource;
        this.chipsInBigBlind = chipsInBigBlind;
        this.playerAction = playerAction;
        this.actualPosition = actualPosition;
        this.actions = actions;
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

    public List<String> getActions() {
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

    public void setActions(List<String> actions) {
        this.actions = actions;
    }
}
