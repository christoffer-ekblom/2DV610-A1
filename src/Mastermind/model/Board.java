package Mastermind.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {

    public static final int DEFAULT_ROW_LENGTH = 4;
    public static final int DEFAULT_TABLE_LENGTH = 15;
    private Row secretCode;

    private List<Row> guessHistory;

    public Board() {
        guessHistory = new ArrayList<>();
        secretCode = null;
    }

    public List<Row> getGuessHistory() {
        return guessHistory;
    }

    public void addGuessToBoard(Row guess) {
        guessHistory.add(guess);
    }

    public Row getSecretCode() {
        return this.secretCode;
    }

    public void setSecretCode(Row secretCode) {
        this.secretCode = secretCode;
    }
}
