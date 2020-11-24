/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import yatzyproject.applogic.Dice;
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
        assertEquals(3, dice.throwCount());
        dice.roll();
        assertEquals(1, dice.throwCount());
    }

    @Test
    public void rollGeneratesFiveValues() {
        dice.roll();
        assertEquals(5, dice.getDiceValuesSize());
    }
}
