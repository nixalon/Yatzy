package kyh.labs.lab5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {

    @Test
    @DisplayName("Testing if the yatzy function works for 1's.")
    void testCheckIfYatzi() {
        Die[] dice = new Die[5];
        dice[0] = new Die(1);
        dice[1] = new Die(1);
        dice[2] = new Die(1);
        dice[3] = new Die(1);
        dice[4] = new Die(1);
        assertTrue(YatziMain.checkIfYatzi(dice));
    }

    @Test
    @DisplayName("Testing if the yatzy function works for no yatzy.")
    void testCheckIfNotYatzi() {
        Die[] dice = new Die[5];
        dice[0] = new Die(1);
        dice[1] = new Die(2);
        dice[2] = new Die(1);
        dice[3] = new Die(1);
        dice[4] = new Die(1);
        assertFalse(YatziMain.checkIfYatzi(dice));
    }

}


/*
public class YatziTest {
    @Test
    void isYatziWhenAllDiceMatches() {
        Die[] dice = new Die[5];
        for(Die die: dice) {
            die.value = 6;
        }
        //Assert something?
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Die[] dice = new Die[5];
        for(Die die: dice) {
            die.value = 6;
        }
        dice[5].value = 1;
        //Assert something?
    }
}
*/