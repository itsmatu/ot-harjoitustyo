package yatzyproject.applogic;

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

    public void removePlayer(String name) {
        this.player.remove(name);
    }

    public String getCurrentPlayer() {
        int playerindex = 0;
        for (String player : this.player.keySet()) {
            if (playerindex == this.index) {
                return player;
            }
        }
        if (this.index++ > this.player.size()) {
            this.index = 0;
        } else {
            this.index++;
        }
        return null;
    }
}
