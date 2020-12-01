package yatzy.applogic;

import java.util.HashMap;

public class Players {

    private HashMap<String, ScoreCard> player;
    private int index;

    public Players() {
        this.player = new HashMap<>();
        this.index = 0;
    }

    public void addPlayer(String name) {
        this.player.put(name, new ScoreCard());
    }

    public boolean containsPlayer(String name) {
        return this.player.containsKey(name);
    }

    public void removePlayer(String name) {
        this.player.remove(name);
    }

    public String getCurrentPlayer() {
        int playerindex = 0;
        for (String player : this.player.keySet()) {
            if (playerindex == this.index) {
                return player;
            } else {
                playerindex++;
            }
        }
        return null;
    }

    public int getPlayerCount() {
        return this.player.size();
    }

    public ScoreCard getPlayerScorecard(String name) {
        return this.player.get(name);
    }

    public void nextPlayer() {
        if (this.index + 1 == this.player.size()) {
            this.index = 0;
        } else {
            this.index++;
        }
    }
}
