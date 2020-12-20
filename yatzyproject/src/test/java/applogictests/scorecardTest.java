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
    
    @Test
    public void bonusIsAwardedCorrectly() {
        score.addScore("ones", 3);
        score.addScore("twos", 6);
        score.addScore("threes", 9);
        score.addScore("fours", 12);
        score.addScore("fives", 15);
        assertEquals(score.bonusAwarded(), false);
        score.addScore("sixes", 18);
        assertEquals(score.bonusAwarded(), true);
    }
    
    @Test
    public void checksIfScorecardIsFull() {
        score.addScore("ones", 3);
        score.addScore("twos", 6);
        score.addScore("threes", 9);
        score.addScore("fours", 12);
        score.addScore("fives", 15);
        score.addScore("sixes", 18);
        score.addScore("pair", 10);
        score.addScore("two pairs", 22);
        score.addScore("three of a kind", 9);
        score.addScore("four of a kind", 16);
        score.addScore("small straight", 15);
        score.addScore("large straight", 20);
        score.addScore("full house", 28);
        score.addScore("chance", 15);
        assertEquals(score.scorecardIsFull(), false);
        score.addScore("yatzy", 50);
        assertEquals(score.scorecardIsFull(), true);
        score.addScore("bonus", 50);
        assertEquals(score.scorecardIsFull(), true);
    }
}
