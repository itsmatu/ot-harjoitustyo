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
}
