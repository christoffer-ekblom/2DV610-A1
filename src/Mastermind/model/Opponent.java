package Mastermind.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Opponent {
    private Row secretCode;
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

    public boolean checkGuess(Row guess) throws Exception {
        if (guess.equals(null)) {
            throw new Exception();
        }

        List<KeyPeg> hint = new ArrayList<>();
        boolean[] used = new boolean[rowLength];

        for(int i = 0; i < rowLength; i++) {
            used[i] = guess.getGuesses().get(i) == secretCode.getGuesses().get(i);
        }

        for(int i = 0; i < rowLength; i++) {
            if(!used[i]) {
                for(int k = 0; k < rowLength; k++) {
                    if(guess.getGuesses().get(i) == secretCode.getGuesses().get(k) && !used[k]) {
                        hint.add(KeyPeg.White);
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < rowLength; i++) {
            if(guess.getGuesses().get(i) == secretCode.getGuesses().get(i)) {
                hint.add(KeyPeg.Black);
            }
        }

        guess.setHint(hint);

        return guess.equals(secretCode);
    }
}
