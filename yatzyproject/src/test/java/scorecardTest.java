
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
        this.score.addScore("Full house", 30);
        assertEquals(this.score.getScore("Full house"), 30);
    }
    
    @Test
    public void checkingIfContainsScoreWorks() {
        this.score.addScore("Full house", 30);
        assertEquals(this.score.doesNotContainScore("Full house"), false);
        assertEquals(this.score.doesNotContainScore("Yatzy"), true);

    }
}
