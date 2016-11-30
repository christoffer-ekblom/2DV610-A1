package Mastermind.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        List<KeyPeg> hint = new ArrayList<>();

        if (guess.getGuesses().equals(secretCode.getGuesses())) {
            for(int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
                hint.add(KeyPeg.Black);
            }

            guess.setHint(hint);
            return true;
        }

        boolean[] used = new boolean[Board.DEFAULT_ROW_LENGTH];

        for (int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            if (guess.getGuesses().get(i) == secretCode.getGuesses().get(i)) {
                used[i] = true;
                hint.add(KeyPeg.Black);
            }
        }

        for (int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            for (int j = 0; j < Board.DEFAULT_ROW_LENGTH; j++) {
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
