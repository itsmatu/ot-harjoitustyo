package yatzyproject.applogic;
import java.util.ArrayList;
import java.util.Collections;

public class Dice {

    private final int max = 6;
    private final int min = 1;
    private final int range = max - min + 1;
    private ArrayList<Integer> diceValues;
    private ArrayList<Integer> selectedDices;
    private int throwIndex;

    public Dice() {
        this.diceValues = new ArrayList<>();
        this.selectedDices = new ArrayList<>();
    }
    
    
    public void roll() {
        this.throwIndex++;
        if (this.throwIndex == 4) {
            this.throwIndex = 1;
        }
        
        this.diceValues.clear();
        for (int i = 0; i < 5; i++) {
            int rand = (int) (Math.random() * range) + min;
            this.diceValues.add(rand);
        }
        Collections.sort(this.diceValues);
    }
    
    public int setDiceValue(int diceorder) {
        return this.diceValues.get(diceorder - 1);
    }
    
    public void addToSelectedDices(int dice) {
        this.selectedDices.add(dice);
    }
    
    public boolean diceIsSelected(int dice) {
        return this.selectedDices.contains(dice);
    }
    
    public void clearSelectedDices() {
        this.selectedDices.clear();
    }
    
    public boolean wasLastRoll() {
        return this.throwIndex == 3;
    }
    
    public int throwCount() {
        return this.throwIndex;
    }
    
    public int getDiceValuesSize() {
        return this.diceValues.size();
    }
}
