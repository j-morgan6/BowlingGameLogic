import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static final int NUMBER_OF_FRAMES = 10;
    public static final int ALL_PINS = 10;
    private final List<Integer> rolls = new ArrayList<Integer>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int calculateScore() {
        int score = 0;
        int offset = 0;
        for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
            score = calculateFrame(offset, score);
            offset = moveToNextFrame(offset);
        }
        return score;
    }

    private int calculateFrame(int offset, int score) {
        if (isStrike(offset))
            score += calculateStrike(offset);
        else if (isSpare(offset)) {
            score += calculateSpare(offset);
        } else {
            score += calculateOpenFrame(offset);
        }
        return score;
    }

    private boolean isStrike(int offset) {
        return ballOne(offset) == ALL_PINS;
    }

    private int calculateStrike(int offset) {
        return ballOne(offset) + ballTwo(offset) + ballThree(offset);
    }

    private int calculateSpare(int offset) {
        return ballOne(offset) + ballTwo(offset) + ballThree(offset);
    }

    private int calculateOpenFrame(int offset) {
        return ballOne(offset) + ballTwo(offset);
    }


    private boolean isSpare(int offset) {
        return ballOne(offset) + ballTwo(offset) == ALL_PINS;
    }

    private Integer ballThree(int offset) {
        return rolls.get(offset + 2);
    }

    private int moveToNextFrame(int offset) {
        if (ballOne(offset) == 10)
            return offset + 1;
        return offset + 2;
    }

    private Integer ballTwo(int offset) {
        return rolls.get(offset + 1);
    }

    private Integer ballOne(int offset) {
        return rolls.get(offset);
    }
}
