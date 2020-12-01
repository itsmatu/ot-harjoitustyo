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
    private int throwIndex;

    public Dice() {
        this.diceValues = new HashMap<>();
        this.selectedDices = new ArrayList<>();
        this.selectedDiceValues = new ArrayList<>();
    }

    public void roll() {
        this.throwIndex++;
        if (this.throwIndex == 4) {
            this.throwIndex = 1;
        }

        for (int i = 0; i < 5; i++) {
            if (!(this.selectedDices.contains(i + 1))) {
                int rand = (int) (Math.random() * range) + min;
                this.diceValues.put(i + 1, rand);
            }
        }
    }

    public int setDiceValue(int diceorder) {
        return this.diceValues.get(diceorder);
    }

    public void addToSelectedDices(int dice, int dicevalue) {
        this.selectedDices.add(dice);
        this.selectedDiceValues.add(dicevalue);
    }

    public boolean diceIsSelected(int dice) {
        return this.selectedDices.contains(dice);
    }

    public void clearSelectedDices() {
        this.selectedDices.clear();
        this.selectedDiceValues.clear();
    }

    public boolean wasLastRoll() {
        return this.throwIndex == 3;
    }
    
    public void endTurn() {
        this.throwIndex = 0;
    }

    public void clearDiceValues() {
        this.diceValues.clear();
    }

    public int throwCount() {
        return this.throwIndex;
    }

    public int getDiceValuesSize() {
        return this.diceValues.size();
    }

    public boolean containsValue(int value) {
        return this.diceValues.containsValue(value);
    }

    public int diceSum(int value) {
        int sum = 0;
        for (Integer val : this.diceValues.keySet()) {
            if (value == this.diceValues.get(val)) {
                sum += value;
            }
        }
        return sum;
    }

    public int onePairSum() {
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            for (int a = 1; a < 6; a++) {
                if (a != i && this.diceValues.get(i) == this.diceValues.get(a) && this.diceValues.get(i) * 2 > sum) {
                    sum = this.diceValues.get(i) * 2;
                }
            }
        }
        return sum;
    }
}
