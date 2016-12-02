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

    public Row getSecretCodeAndChangeIt() throws Exception {
        Row code = secretCode;
        this.generateSecretCode();
        return code;
    }

    public boolean checkGuess(Row guess) throws Exception {
        if (guess == null || guess.getGuesses() == null) {
            throw new Exception();
        }

        List<KeyPeg> hint = new ArrayList<>();
        boolean[] incorrect = {true, true, true, true};
        boolean[] untaken = {true, true, true, true};

        for(int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            if(guess.getGuesses().get(i) == secretCode.getGuesses().get(i)) {
                incorrect[i] = false;
                untaken[i] = false;
            }
        }

        for(int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            if(incorrect[i]) {
                for(int k = 0; k < Board.DEFAULT_ROW_LENGTH; k++) {
                    if(guess.getGuesses().get(i) == secretCode.getGuesses().get(k) && untaken[k]) {
                        hint.add(KeyPeg.White);
                        untaken[k]=false;
                        k = Board.DEFAULT_ROW_LENGTH + 1;
                    }
                }
            }
        }

        for(int i = 0; i < Board.DEFAULT_ROW_LENGTH; i++) {
            if(guess.getGuesses().get(i) == secretCode.getGuesses().get(i)) {
                hint.add(KeyPeg.Black);
            }
        }

        guess.setHint(hint);

        if(guess.equals(secretCode)) {
            return true;
        }

        return false;
    }
}
