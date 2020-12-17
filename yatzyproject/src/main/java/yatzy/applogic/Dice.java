package yatzy.applogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Dice {

    private final int max = 6;
    private final int min = 1;
    private final int range = max - min + 1;
    private HashMap<Integer, Integer> diceValues;
    private ArrayList<Integer> selectedDices;
    private ArrayList<Integer> selectedDiceValues;
    private int rollIndex;

    public Dice() {
        this.diceValues = new HashMap<>();
        this.selectedDices = new ArrayList<>();
        this.selectedDiceValues = new ArrayList<>();
    }

    /**
     * Method is used only for testing purposes
     */
    public void addValues(int index, int value) {
        this.diceValues.put(index, value);
    }
    
    /**
     * Method generates five random values between 1-6
     *
     */
    public void roll() {
        this.rollIndex++;
        if (this.rollIndex == 4) {
            this.rollIndex = 1;
        }

        for (int i = 0; i < 5; i++) {
            if (!(this.selectedDices.contains(i + 1))) {
                int rand = (int) (Math.random() * range) + min;
                this.diceValues.put(i + 1, rand);
            }
        }
    }

    /**
     * Method looks for the correct value from diceValues ArrayList to be set on
     * the matching dice button.
     *
     * @param diceorder "index" of the dice counted from the rightmost dice
     * button
     * @return Returns the matching value for the intended dice
     */
    public int setDiceValue(int diceorder) {
        return this.diceValues.get(diceorder);
    }

    /**
     * Method adds dices that the player has selected to be held for another
     * throw
     *
     * @param dice the index of the dice
     * @param dicevalue the value of the dice
     */
    public void addToSelectedDices(int dice, int dicevalue) {
        this.selectedDices.add(dice);
        this.selectedDiceValues.add(dicevalue);
    }

    /**
     * Method checks wether certain dice has been selected
     *
     * @param dice the index of the dice
     * @return Returns either true or false
     */
    public boolean diceIsSelected(int dice) {
        return this.selectedDices.contains(dice);
    }

    /**
     * Method clears the ArrayList containing dices that has been selected
     */
    public void clearSelectedDices() {
        this.selectedDices.clear();
        this.selectedDiceValues.clear();
    }

    /**
     * Method checks wether player threw for their last time (3 times max)
     *
     * @return Returns wether it was their last throw or not (true or false)
     */
    public boolean wasLastRoll() {
        return this.rollIndex == 3;
    }

    /**
     * Method resets rollIndex value to 0 This method is meant to be used just
     * before switching to the next player
     */
    public void endTurn() {
        this.rollIndex = 0;
    }

    /**
     * Method clears diceValues ArrayList containing current dice values This
     * method is meant to be used just before switching to the next player
     */
    public void clearDiceValues() {
        this.diceValues.clear();
    }

    /**
     * Method returns the amount of rolls a player has made during one turn
     *
     * @return Returns an integer value
     */
    public int rollCount() {
        return this.rollIndex;
    }

    /**
     * Methods returns the size of diceValues ArrayList
     *
     * @return Returns an integer value
     */
    public int getDiceValuesSize() {
        return this.diceValues.size();
    }

    /**
     * Methods checks wether certain value is inside diceValues ArrayList
     *
     * @param value Value that will be checked
     * @return Returns true or false wether said value was in the ArrayList
     */
    public boolean containsValue(int value) {
        return this.diceValues.containsValue(value);
    }

    /**
     * Method is used to get the sum of dices containing certain value
     *
     * @param value The value we want to be summed from all dices containing
     * said value
     * @return Returns an integer value from the summed values
     */
    public int diceSum(int value) {
        int sum = 0;
        for (Integer val : this.diceValues.keySet()) {
            if (value == this.diceValues.get(val)) {
                sum += value;
            }
        }
        return sum;
    }

    /**
     * Method check for the highest possible pair and sums them
     *
     * @return Returns an integer value
     */
    public int onePairSum() {
        int sum = 0;
        try {
            for (int i = 1; i < 6; i++) {
                for (int a = 1; a < 6; a++) {
                    if (a != i && this.diceValues.get(i) == this.diceValues.get(a) && this.diceValues.get(i) * 2 > sum) {
                        sum = this.diceValues.get(i) * 2;
                    }
                }
            }
        } catch (Exception e) {

        }
        return sum;
    }

    /**
     * Method checks for the highest possible two pairs and sums them
     *
     * @return Returns an integer value
     */
    public int twoPairSum() {
        ArrayList<Integer> helpingList = new ArrayList<>();
        int sum = 0;
        try {
            for (Integer value : this.diceValues.keySet()) {
                helpingList.add(this.diceValues.get(value));
            }
            Collections.sort(helpingList);

            int firstPair = 0;
            for (int i = 0; i < 5; i++) {
                for (int a = 0; a < 5; a++) {
                    if (a != i && helpingList.get(i) == helpingList.get(a) && helpingList.get(i) * 2 > firstPair) {
                        firstPair = helpingList.get(i) * 2;
                        sum += helpingList.get(i) * 2;
                    }
                }
            }
        } catch (Exception e) {

        }
        return sum;
    }

    /**
     * Method checks for three same values from rolled dices and sums them
     *
     * @return Returns an integer value
     */
    public int threeOfAKindSum() {
        int sum = 0;
        int value = 0;
        try {
            for (int i = 1; i < 6; i++) {
                for (int a = 1; a < 6; a++) {
                    if (a != i && this.diceValues.get(i) == this.diceValues.get(a)) {
                        value++;
                    }
                    if (value == 2) {
                        return this.diceValues.get(i) * 3;
                    }
                }
                value = 0;
            }
        } catch (Exception e) {

        }
        return sum;
    }

    /**
     * Method checks for four same values from rolled dices and sums them
     *
     * @return Returns an integer value
     */
    public int fourOfAKindSum() {
        int sum = 0;
        int value = 0;
        try {
            for (int i = 1; i < 6; i++) {
                for (int a = 1; a < 6; a++) {
                    if (a != i && this.diceValues.get(i) == this.diceValues.get(a)) {
                        value++;
                    }
                    if (value == 3) {
                        return this.diceValues.get(i) * 4;
                    }
                }
                value = 0;
            }
        } catch (Exception e) {

        }
        return sum;
    }

    /**
     * Method checks wether a player has either a small straight (1,2,3,4,5) or
     * a large straight (2,3,4,5,6)
     *
     * @return Returns an integer value
     */
    public int straightSum() {
        ArrayList<Integer> helpingList = new ArrayList<>();
        int sum = 0;
        try {
            for (Integer value : this.diceValues.keySet()) {
                helpingList.add(this.diceValues.get(value));
            }
            Collections.sort(helpingList);

            if (helpingList.get(0) == 1
                    && helpingList.get(1) == 2
                    && helpingList.get(2) == 3
                    && helpingList.get(3) == 4
                    && helpingList.get(4) == 5) {
                sum = 15;
            } else if (helpingList.get(0) == 2
                    && helpingList.get(1) == 3
                    && helpingList.get(2) == 4
                    && helpingList.get(3) == 5
                    && helpingList.get(4) == 6) {
                sum = 20;
            }
        } catch (Exception e) {

        }

        return sum;
    }

    /**
     * Method checks wether a player has a full house (For example 4,4,6,6,6)
     *
     * @return Returns an integer value
     */
    public int fullHouseSum() {
        ArrayList<Integer> helpingList = new ArrayList<>();
        int sum = 0;
        try {
            for (Integer value : this.diceValues.keySet()) {
                helpingList.add(this.diceValues.get(value));
            }
            Collections.sort(helpingList);

            if (helpingList.get(0) == helpingList.get(1) && helpingList.get(1) == helpingList.get(2) && helpingList.get(3) == helpingList.get(4)) {
                sum = (helpingList.get(0) * 3) + (helpingList.get(3) * 2);
            } else if (helpingList.get(0) == helpingList.get(1) && helpingList.get(2) == helpingList.get(3) && helpingList.get(3) == helpingList.get(4)) {
                sum = (helpingList.get(0) * 2) + (helpingList.get(3) * 3);
            }
        } catch (Exception e) {

        }
        return sum;
    }

    /**
     * Method checks wether a player has rolled 5 same values
     *
     * @return Returns an integer value
     */
    public int addYatzy() {
        ArrayList<Integer> helpingList = new ArrayList<>();
        int sum = 0;
        try {
            for (Integer value : this.diceValues.keySet()) {
                helpingList.add(this.diceValues.get(value));
            }
            Collections.sort(helpingList);
            if (helpingList.get(0) == helpingList.get(1) && helpingList.get(0) == helpingList.get(2) && helpingList.get(0) == helpingList.get(3) && helpingList.get(0) == helpingList.get(4)) {
                sum = 50;
            }
        } catch (Exception e) {

        }

        return sum;
    }

    /**
     * Method sums up all of the dices rolled
     *
     * @return Returns an integer value
     */
    public int addChance() {
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            try {
                sum += this.diceValues.get(i);
            } catch (Exception e) {
            }
        }
        return sum;
    }
}
