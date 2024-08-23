import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("A Bowling Game")
public class BowlingGameTest {

    private BowlingGame gameTest;

    @BeforeEach
    public void setUp() {
        gameTest = new BowlingGame();
    }

    @Test
    @DisplayName("should score zero when all gutters")
    public void allGutters() {
        rollMany(20, 0);
        assertEquals(0, gameTest.calculateScore());
    }

    @Test
    @DisplayName("bowl twenty times getting 1 each time")
    public void allOnes() {
        rollMany(20, 1);
        assertEquals(20, gameTest.calculateScore());
    }

    @Test
    @DisplayName("calculate a spare correctly")
    public void testSpare() {
        gameTest.roll(5);
        gameTest.roll(5);
        gameTest.roll(3);
        rollMany(17,0);
        assertEquals(16, gameTest.calculateScore());
    }

    @Test
    @DisplayName("calculate score after a strike")
    public void testStrike() {
        gameTest.roll(10);
        gameTest.roll(3);
        gameTest.roll(3);
        rollMany(16,0);
        assertEquals(22,gameTest.calculateScore());
    }

    @Test
    @DisplayName("calculate spare on the final frame")
    public void testSpareFinalFrame() {
        rollMany(18,0);
        gameTest.roll(5);
        gameTest.roll(5);
        gameTest.roll(3);
        assertEquals(13, gameTest.calculateScore());
    }

    @Test
    @DisplayName("calculate all strikes")
    public void allStrikes() {
        rollMany(12,10);
        assertEquals(300, gameTest.calculateScore());
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            gameTest.roll(pins);
        }
    }
}
