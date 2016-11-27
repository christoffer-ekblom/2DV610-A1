package Mastermind.model;

import java.util.Arrays;
import java.util.List;

public class Board {

    public static final int DEFAULT_ROW_LENGTH = 4;
    public static final int DEFAULT_TABLE_LENGTH = 10;

    private List<Row> guessHistory;

    public Board() {
        guessHistory = Arrays.asList(new Row[DEFAULT_TABLE_LENGTH]);
    }

    public List<Row> getGuessHistory() {
        return guessHistory;
    }

    public void addGuessToBoard(Row guess) {

    }
}
