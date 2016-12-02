package Mastermind.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Opponent {
    private Row secretCode;
    private Row guess;
    private int rowLength = Board.DEFAULT_ROW_LENGTH;

    public void generateSecretCode() throws Exception {
        List<Integer> secret = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            secret.add(random.nextInt(SymbolPeg.values().length));
        }

        List<SymbolPeg> symbolPegs = SymbolPeg.getByInteger(secret);

        secretCode = new Row(symbolPegs);
    }

    public Row getSecretCodeAndChangeIt() throws Exception {
        Row code = secretCode;
        this.generateSecretCode();
        return code;
    }

    public boolean checkGuess(Row guess) {
        List<KeyPeg> hint = new ArrayList<>();
        this.guess = guess;

        for(int i = 0; i < rowLength; i++) {
            if(correctColorCorrectPosition(i)) {
                hint.add(KeyPeg.Black);
                continue;
            }
            for(int k = 0; k < rowLength; k++) {
                if(correctColorWrongPosition(i, k)) {
                    hint.add(KeyPeg.White);
                    break;
                }
            }
        }

        guess.setHint(hint);

        return guess.equals(secretCode);
    }

    private boolean correctColorWrongPosition(int i, int k) {
        return equal(i, k) && !correctColorCorrectPosition(k);
    }

    private boolean correctColorCorrectPosition(int i) {
        return equal(i, i);
    }

    private boolean equal(int i, int k) {
        return guess.getGuesses().get(i) == secretCode.getGuesses().get(k);
    }
}
