package Mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int DEFAULT_ROW_LENGTH = 4;
    public static final int DEFAULT_TABLE_LENGTH = 10;

    private List<Row> guessHistory;

    public Board() {
        guessHistory = new ArrayList<>();
    }

    public List<Row> getGuessHistory() {
        return guessHistory;
    }

    public void addGuessToBoard(Row guess) {
        guessHistory.add(guess);
    }
}
