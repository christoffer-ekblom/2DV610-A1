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
            if(check(i)) {
                for(int k = 0; k < rowLength; k++) {
                    if(guess.getGuesses().get(i) == secretCode.getGuesses().get(k) && check(k)) {
                        hint.add(KeyPeg.White);
                    }
                }
                continue;
            }
            hint.add(KeyPeg.Black);
        }

        guess.setHint(hint);

        return guess.equals(secretCode);
    }

    private boolean check(int i) {
        return !(guess.getGuesses().get(i) == secretCode.getGuesses().get(i));
    }
}
