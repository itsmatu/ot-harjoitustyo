/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import yatzy.applogic.Players;
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
public class playersTest {

    Players player;

    public playersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.player = new Players();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addingAndRemovingPlayersWorks() {
        player.addPlayer("test");
        assertEquals(1, player.getPlayerCount());
        player.removePlayer("test");
        assertEquals(0, player.getPlayerCount());
    }

    @Test
    public void containsPlayerWorks() {
        player.addPlayer("test");
        assertEquals(player.containsPlayer("test"), true);
        assertEquals(player.containsPlayer("testtest"), false);
    }

    @Test
    public void getCurrentPlayerWorks() {
        player.addPlayer("test");
        assertEquals(player.getCurrentPlayer(), "test");
    }

    @Test
    public void getPlayerCountWorks() {
        player.addPlayer("test1");
        player.addPlayer("test2");
        assertEquals(player.getPlayerCount(), 2);
    }

    @Test
    public void getPlayerScorecardWorks() {
        player.addPlayer("test");
        // I have to add a random score to the scorecard to check wether it actually retrieved a scorecard object
        player.getPlayerScorecard("test").addScore("yatzy", 50);
        assertEquals(player.getPlayerScorecard("test").getScoreSum(), 50);
    }
    
    @Test
    public void changingPlayerWorks() {
        player.addPlayer("a");
        player.addPlayer("b");
        player.addPlayer("c");
        assertEquals(player.getCurrentPlayer(), "a");
        player.nextPlayer();
        assertEquals(player.getCurrentPlayer(), "b");
        player.nextPlayer();
        assertEquals(player.getCurrentPlayer(), "c");
    }
}
