package yatzy.applogic;

import java.util.HashMap;

public class ScoreCard {

    private final HashMap<String, Integer> scores;

    public ScoreCard() {
        this.scores = new HashMap<>();
    }
    
    public void addScore(String scorename, int value) {
        this.scores.put(scorename, value);
    }
    
    public int getScore(String scorename) {
        return this.scores.get(scorename);
    }
    
    public boolean doesNotContainScore(String scorename) {
        if (this.scores.containsKey(scorename)) {
            return false;
        } else {
            return true;
        }
    }
    
    public int getScoreSum() {
        int sumReturn = 0;
        for (String value : this.scores.keySet()) {
            sumReturn += this.scores.get(value);
        }
        return sumReturn;
    }
 }
