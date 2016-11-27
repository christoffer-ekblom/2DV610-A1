package Mastermind.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class Opponent {

    private Row secretCode;

    public void generateSecretCode() throws Exception {
        List<Integer> secret = new ArrayList<>();
        for (int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
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
        boolean[] used = new boolean[Board.DEFAULT_ROW_LENGTH];

        for (int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            if (guess.getSymbolPegs().get(i) == secretCode.getSymbolPegs().get(i)) {
                hint.add(KeyPeg.Black);
                used[i] = true;
                continue;
            }

            for (int j = 0; j < Board.DEFAULT_ROW_LENGTH; j++) {
                if (used[j]) {
                    continue;
                }
                if (guess.getSymbolPegs().get(i) == secretCode.getSymbolPegs().get(j)) {
                    used[j] = true;
                    hint.add(KeyPeg.White);
                    break;
                }
            }
        }

        guess.setHint(hint);
    }
}
