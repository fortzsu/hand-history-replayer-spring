package com.example.handhistoryreplayerspring.service;

import com.example.handhistoryreplayerspring.domain.Action;
import com.example.handhistoryreplayerspring.domain.Hand;
import com.example.handhistoryreplayerspring.domain.Player;
import com.example.handhistoryreplayerspring.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService {

    private final ActionRepository actionRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public void createAction(List<String> originalLines, String cards, List<Player> players, Hand hand) {
        List<String> allOriginalActionLines =
                findActionsFromOriginalLines(originalLines.indexOf(cards) + 1, originalLines);
        fillHandsPlayerActions(allOriginalActionLines, players, hand);
    }

    private List<String> findActionsFromOriginalLines(int i, List<String> originalLines) {
        List<String> allActions = new ArrayList<>();
        while (!originalLines.get(i).contains("Uncalled")
                && !originalLines.get(i).contains("*") && i < originalLines.size() - 1) {
            allActions.add(originalLines.get(i));
            i++;
        }
        return allActions;
    }

    private void fillHandsPlayerActions(List<String> allOriginalActionLines, List<Player> players, Hand hand) {
        for (String actionLine : allOriginalActionLines) {
            addPlayerActions(actionLine, players, hand);
        }
    }

    public void addPlayerActions(String originalLineOfAction, List<Player> players, Hand hand) {
        int splitIndex = originalLineOfAction.indexOf(':');
        if (splitIndex > -1) {
            String name = originalLineOfAction.substring(0, splitIndex);
            String action = originalLineOfAction.substring(splitIndex + 2);
            findPlayerAndSaveAction(name, action, players, hand);
        }
    }

    private void findPlayerAndSaveAction(String name, String actionLine, List<Player> players, Hand hand) {
        Action action = new Action();
        action.setAction(actionLine);
        action.setHand(hand);
        for (Player player : players) {
            if(player.getPlayerName().equals(name)) {
                action.setPlayer(player);
            }
        }
        this.actionRepository.save(action);
    }

    public List<Action> findActionsByPlayer(Hand hand) {
        return this.actionRepository.findAllByHand(hand);
    }

}
