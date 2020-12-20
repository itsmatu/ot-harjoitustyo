package applogictests;

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
    public void endingTurnResetsIndexToZero() {
        dice.roll();
        dice.roll();
        assertEquals(dice.rollCount(), 2);
        dice.endTurn();
        assertEquals(dice.rollCount(), 0);
    }

    @Test
    public void clearDiceValuesWorks() {
        dice.roll();
        assertEquals(dice.getDiceValuesSize(), 5);
        dice.clearDiceValues();
        assertEquals(dice.getDiceValuesSize(), 0);
    }

    @Test
    public void straightSumWorks() {
        dice.addValues(1, 1);
        dice.addValues(2, 2);
        dice.addValues(3, 3);
        dice.addValues(4, 4);
        dice.addValues(5, 5);
        assertEquals(dice.straightSum(), 15);
        dice.addValues(1, 2);
        dice.addValues(2, 3);
        dice.addValues(3, 4);
        dice.addValues(4, 5);
        dice.addValues(5, 6);
        assertEquals(dice.straightSum(), 20);
        dice.addValues(1, 2);
        dice.addValues(2, 4);
        dice.addValues(3, 4);
        dice.addValues(4, 5);
        dice.addValues(5, 6);
        assertEquals(dice.straightSum(), 0);
    }

    @Test
    public void fullHouseSumWorks() {
        dice.addValues(1, 1);
        dice.addValues(2, 1);
        dice.addValues(3, 1);
        dice.addValues(4, 2);
        dice.addValues(5, 2);
        assertEquals(dice.fullHouseSum(), 7);
        dice.addValues(1, 1);
        dice.addValues(2, 1);
        dice.addValues(3, 1);
        dice.addValues(4, 2);
        dice.addValues(5, 3);
        assertEquals(dice.fullHouseSum(), 0);

    }
    
    @Test
    public void twoPairSumWorks() {
        dice.addValues(1, 2);
        dice.addValues(2, 2);
        dice.addValues(3, 5);
        dice.addValues(4, 5);
        dice.addValues(5, 4);
        assertEquals(dice.twoPairSum(), 14);
    }
    
    @Test
    public void addingYatzyWorks() {
        dice.addValues(1, 5);
        dice.addValues(2, 5);
        dice.addValues(3, 5);
        dice.addValues(4, 5);
        dice.addValues(5, 5);
        assertEquals(dice.addYatzy(), 50);
    }
    
    @Test
    public void onePairSumWorks() {
        dice.addValues(1, 1);
        dice.addValues(2, 2);
        dice.addValues(3, 5);
        dice.addValues(4, 5);
        dice.addValues(5, 4);
        assertEquals(dice.onePairSum(), 10);
    }
    
    @Test
    public void threeOfAKindSumWorks() {
        dice.addValues(1, 2);
        dice.addValues(2, 5);
        dice.addValues(3, 5);
        dice.addValues(4, 5);
        dice.addValues(5, 4);
        assertEquals(dice.threeOfAKindSum(), 15);
    }
    
    @Test
    public void fourOfAKindSumWorks() {
        dice.addValues(1, 2);
        dice.addValues(2, 5);
        dice.addValues(3, 5);
        dice.addValues(4, 5);
        dice.addValues(5, 5);
        assertEquals(dice.fourOfAKindSum(), 20);
    }
    
    @Test
    public void diceSumWorks() {
        dice.addValues(1, 2);
        dice.addValues(2, 2);
        dice.addValues(3, 2);
        dice.addValues(4, 5);
        dice.addValues(5, 4);
        assertEquals(dice.diceSum(2), 6);
    }
    
    @Test
    public void addingChanceWorks() {
        dice.addValues(1, 2);
        dice.addValues(2, 2);
        dice.addValues(3, 5);
        dice.addValues(4, 5);
        dice.addValues(5, 4);
        assertEquals(dice.addChance(), 18);
    }
    
    @Test
    public void checkingForValuesWorks() {
        dice.addValues(1, 2);
        dice.addValues(2, 2);
        dice.addValues(3, 5);
        dice.addValues(4, 5);
        dice.addValues(5, 4);
        assertEquals(dice.containsValue(4), true);
        assertEquals(dice.containsValue(3), false);
    }
}
