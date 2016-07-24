import CK.Assignment1.NameInputAssignment1;
import CK.FileIO.Highscore.HighscoreStore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HighScoreTest {
    @Test
    public void an_empty_file_returns_an_empty_array() {
        HighscoreStore hss = new HighscoreStore("tests/HighScoreTest_EmptyFile.txt");

        assertEquals(0, hss.getHighscores().size());
    }

    @Test
    public void a_non_empty_file_returns_a_non_empty_array(){
        HighscoreStore hss = new HighscoreStore("tests/HighScoreTest_BasicData.txt");

        assertEquals(2, hss.getHighscores().size());
    }

    @Test
    public void if_checking_a_score_for_an_existing_user_return_true_when_checked(){
        HighscoreStore hss = new HighscoreStore("tests/HighScoreTest_BasicData.txt");

        assertTrue(hss.isUserNewRecord("AL", 7890));
    }

    @Test
    public void if_checking_a_score_for_an_existing_user_but_it_isnt_higher_return_false_when_checked(){
        HighscoreStore hss = new HighscoreStore("tests/HighScoreTest_BasicData.txt");

        assertFalse(hss.isUserNewRecord("AL", 50));
    }

    @Test
    public void determine_the_location_of_a_highscore(){
        HighscoreStore hss = new HighscoreStore("tests/HighScoreTest_BasicData.txt");

        assertEquals(1, hss.findHighscorePosition(2345));
    }
}
