package Mastermind.model;

import com.intellij.ide.ui.AppearanceOptionsTopHitProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    }

    public List<KeyPeg> getHint() {
        List<KeyPeg> keyPeg = new ArrayList<>();
        Random random = new Random();
        int num;

        for (int i = 0; i < rowLength; i++) {
            num = random.nextInt(2);
            if (num == 0) {
                keyPeg.add(KeyPeg.Black);
            } else {
                keyPeg.add(KeyPeg.White);
            }
        }

        return keyPeg;
    }
}
