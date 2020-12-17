package applogictests;


import yatzy.applogic.ScoreCard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class scorecardTest {
    
    ScoreCard score;
    
    public scorecardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.score = new ScoreCard();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addScoreWorks() {
        score.addScore("Full house", 30);
        assertEquals(score.getScore("Full house"), 30);
    }
    
    @Test
    public void checkingIfContainsScoreWorks() {
        score.addScore("Full house", 30);
        assertEquals(score.doesNotContainScore("Full house"), false);
        assertEquals(score.doesNotContainScore("Yatzy"), true);

    }
    
    @Test
    public void getScoreWorks() {
        score.addScore("one pair", 6);
        assertEquals(score.getScore("one pair"), 6);
    }
    
    @Test
    public void getScoreSumWorks() {
        score.addScore("one pair", 6);
        score.addScore("yatzy", 50);
        score.addScore("fours", 16);
        assertEquals(score.getScoreSum(), 72);
    }
}
