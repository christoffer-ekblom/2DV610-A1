package Mastermind.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {

    public static final int DEFAULT_ROW_LENGTH = 4;
    public static final int DEFAULT_TABLE_LENGTH = 15;

    private boolean isGameOver = false;

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

    public Row getSecretCodeFromOpponent(Opponent opponent) throws Exception {
        return opponent.getSecretCodeAndChangeIt();
    }

    public boolean isGameOver() {
        return this.isGameOver;
    }

    public void setGameOver() {
        
    }
}
