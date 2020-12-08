package yatzy.applogic;

import java.util.HashMap;

public class ScoreCard {

    private final HashMap<String, Integer> scores;

    public ScoreCard() {
        this.scores = new HashMap<>();
    }
    
    /**
     * Method is used to add a certain score to the players scorecard
     * @param scorename String value of the name of the score (ones, twos, one pair, four of a kind...)
     * @param value Integer value of the sum of specified score type
     */
    public void addScore(String scorename, int value) {
        this.scores.put(scorename, value);
    }
    
    /**
     * Method retrieves a specified score from the players scorecard
     * @param scorename String value of the name of the score
     * @return Returns an integer value of the score
     */
    public int getScore(String scorename) {
        return this.scores.get(scorename);
    }
    
    /**
     * Method checks wether a certain score has already been added
     * @param scorename String value of the name of the score to be checked
     * @return Returns true or false
     */
    public boolean doesNotContainScore(String scorename) {
        if (this.scores.containsKey(scorename)) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Method is used to get the total sum of all scores in a players scorecard
     * @return Returns an integer value of the sum
     */
    public int getScoreSum() {
        int sumReturn = 0;
        for (String value : this.scores.keySet()) {
            sumReturn += this.scores.get(value);
        }
        return sumReturn;
    }
 }
