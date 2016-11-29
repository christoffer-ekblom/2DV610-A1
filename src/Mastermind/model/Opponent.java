package Mastermind.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.shuffle;

public class Opponent {
    private Row secretCode;

    public void generateSecretCode() throws Exception {
        List<Integer> secret = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            secret.add(random.nextInt(SymbolPeg.values().length));
        }

        List<SymbolPeg> symbolPegs = SymbolPeg.getByInteger(secret);

        secretCode = new Row(symbolPegs);
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
                used[i] = true;
                hint.add(KeyPeg.Black);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (used[j])
                    continue;
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
