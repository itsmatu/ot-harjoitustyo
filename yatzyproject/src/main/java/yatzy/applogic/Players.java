package yatzy.applogic;

import java.util.HashMap;

public class Players {

    private HashMap<String, ScoreCard> players;
    private int index;

    public Players() {
        this.players = new HashMap<>();
        this.index = 0;
    }

    /**
     * Method adds a player and a new ScoreCard object to the players HashMap
     * @param name String value that was retrieved from the text field
     */
    public void addPlayer(String name) {
        this.players.put(name, new ScoreCard());
    }

    /**
     * Method check wether a certain player has been added to the players HashMap
     * @param name Name to be checked
     * @return Returns false or true
     */
    public boolean containsPlayer(String name) {
        return this.players.containsKey(name);
    }

    /**
     * Method removes a given player from the players HashMap
     * @param name Name to be removed
     */
    public void removePlayer(String name) {
        this.players.remove(name);
    }

    /**
     * Method returns the player which is in play during that round
     * @return String value of the name
     */
    public String getCurrentPlayer() {
        int playerindex = 0;
        for (String player : this.players.keySet()) {
            if (playerindex == this.index) {
                return player;
            } else {
                playerindex++;
            }
        }
        return null;
    }

    /**
     * Methods indicates the size of the players HashMap
     * @return Returns an int value of the amount of players
     */
    public int getPlayerCount() {
        return this.players.size();
    }

    /**
     * Method retrieves a ScoreCard object for a specified player
     * This method is used while adding adding values to a players scorecard
     * @param name String value of the name
     * @return Returns a ScoreCard object
     */
    public ScoreCard getPlayerScorecard(String name) {
        return this.players.get(name);
    }

    /**
     * This method is used to move index variable forward by one
     * If the index variable is greater than the size of the players HashMap, it resets the value of the index variable to 0
     */
    public void nextPlayer() {
        if (this.index + 1 == this.players.size()) {
            this.index = 0;
        } else {
            this.index++;
        }
    }
}
