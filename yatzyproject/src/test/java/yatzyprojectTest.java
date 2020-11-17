
import yatzyproject.applogic.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class yatzyprojectTest {

    Dice dice;
    Players player;

    public yatzyprojectTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dice = new Dice();
        player = new Players();
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

    @Test
    public void addingAndRemovingPlayersWorks() {
        player.addPlayer("test");
        assertEquals(1, player.getPlayerCount());
        player.removePlayer("test");
        assertEquals(0, player.getPlayerCount());

    }
}
