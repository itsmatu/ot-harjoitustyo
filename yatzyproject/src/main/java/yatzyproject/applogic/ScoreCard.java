package yatzyproject.applogic;

import java.util.HashMap;

public class ScoreCard {

    private final HashMap<String, Integer> upperScores;
    private final HashMap<String, Integer> lowerScores;

    public ScoreCard() {
        this.upperScores = new HashMap<>();
        this.lowerScores = new HashMap<>();
    }
}
