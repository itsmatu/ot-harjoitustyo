/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import yatzy.applogic.Dice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matu
 */
public class diceTest {
    
    Dice dice;
    
    public diceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.dice = new Dice();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void throwCountIsLimitedToThree() {
        dice.roll();
        dice.roll();
        dice.roll();
        assertEquals(3, dice.rollCount());
        dice.roll();
        assertEquals(1, dice.rollCount());
    }

    @Test
    public void rollGeneratesFiveValues() {
        dice.roll();
        assertEquals(5, dice.getDiceValuesSize());
    }
    
    @Test
    public void addingToSelectedDicesWorks() {
        dice.roll();
        dice.addToSelectedDices(1, 1);
        assertEquals(dice.diceIsSelected(1), true);
    }
    
    @Test
    public void clearSelectedDicesWorks() {
        dice.roll();
        dice.addToSelectedDices(1, 1);
        assertEquals(dice.diceIsSelected(1), true);
        dice.clearSelectedDices();
        assertEquals(dice.diceIsSelected(1), false);
    }
    
    @Test
    public void checkingIfItWasLastRoll() {
        dice.roll();
        dice.roll();
        assertEquals(dice.wasLastRoll(), false);
        dice.roll();
        assertEquals(dice.wasLastRoll(), true);
    }
    
    @Test
    public void clearDiceValuesWorks() {
        dice.roll();
        assertEquals(dice.getDiceValuesSize(), 5);
        dice.clearDiceValues();
        assertEquals(dice.getDiceValuesSize(), 0);
    }
}
