package Mastermind.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class Opponent {

    private int rowLength;
    private Row secretCode;

    public Opponent() {
        this.rowLength = Board.DEFAULT_ROW_LENGTH;
    }

    public Opponent(int rowLength) throws Exception {
        if (rowLength < Board.MINIMUM_ROW_LENGTH || rowLength > Board.MAXIMUM_ROW_LENGTH) {
            throw new Exception();
        }

        this.rowLength = rowLength;
    }

    public int getRowLength() {
        return this.rowLength;
    }

    public void generateSecretCode() throws Exception {
        List<Integer> secret = new ArrayList<>();
        for (int i = 0; i < rowLength; i++) {
            secret.add(i);
        }
        shuffle(secret);

        List<SymbolPeg> symbolPegs = SymbolPeg.getByInteger(secret);

        this.secretCode = new Row(symbolPegs);
    }

    public void checkGuess(Row guess) throws Exception {
        if (guess == null || guess.getSymbolPegs() == null) {
            throw new Exception();
        }

        List<KeyPeg> hint = new ArrayList<>();

        for (int i = 0; i < guess.getSymbolPegs().size(); i++) {
            if (guess.getSymbolPegs().get(i) == secretCode.getSymbolPegs().get(i)) {
                hint.add(KeyPeg.Black);
            }
        }

        guess.setHint(hint);
    }
}
