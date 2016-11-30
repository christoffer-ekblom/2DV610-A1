package Mastermind.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {

    public static final int DEFAULT_ROW_LENGTH = 4;
    public static final int DEFAULT_TABLE_LENGTH = 15;

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
        List<SymbolPeg> code = new LinkedList<>();
        code.add(SymbolPeg.Club);
        return new Row(code);
    }
}
