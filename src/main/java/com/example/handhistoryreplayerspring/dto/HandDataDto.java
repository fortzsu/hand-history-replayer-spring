package com.example.handhistoryreplayerspring.dto;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;

import java.util.List;

public class HandDataDto {
    private Integer id;
    private String firstImgSource;
    private String secondImgSource;
    private String chipsInBigBlind;
    private String actualPosition;
    private List<String> actions;

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


    public void setActualPosition(String actualPosition) {
        this.actualPosition = actualPosition;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }
}
