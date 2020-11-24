package yatzyproject.applogic;

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
 }
