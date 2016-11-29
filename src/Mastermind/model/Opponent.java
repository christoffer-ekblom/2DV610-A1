package Mastermind.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class Opponent {
    private Row secretCode;

    public void generateSecretCode() throws Exception {
        List<Integer> secret = new ArrayList<>();
        for (int i = 0; i < SymbolPeg.values().length; i++) {
            secret.add(i);
        }
        shuffle(secret);

        List<SymbolPeg> symbolPegs = SymbolPeg.getByInteger(secret);

        this.secretCode = new Row(symbolPegs);
    }

    public boolean checkGuess(Row guess) throws Exception {
        if (guess == null || guess.getGuesses() == null) {
            throw new Exception();
        }

        if(guess.getGuesses().equals(secretCode.getGuesses())) {
            return true;
        }

        List<KeyPeg> hint = new ArrayList<>();
        boolean[] used = new boolean[Board.DEFAULT_ROW_LENGTH];

        for (int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            if (guess.getGuesses().get(i) == secretCode.getGuesses().get(i)) {
                hint.add(KeyPeg.Black);
                used[i] = true;
                continue;
            }

            for (int j = 0; j < Board.DEFAULT_ROW_LENGTH; j++) {
                if (used[j]) {
                    continue;
                }
                if (guess.getGuesses().get(i) == secretCode.getGuesses().get(j)) {
                    used[j] = true;
                    hint.add(KeyPeg.White);
                    break;
                }
            }
        }

        guess.setHint(hint);

        return false;
    }
}
