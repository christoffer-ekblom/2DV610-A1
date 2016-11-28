package Mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private List<SymbolPeg> guesses;
    private List<KeyPeg> hints;

    public Row() {

    }

    public Row(List<SymbolPeg> guesses) throws Exception {
        this(guesses, new ArrayList<>());
    }

    public Row(List<SymbolPeg> guesses, List<KeyPeg> hints) throws Exception {
        if (guesses.isEmpty()) {
            throw new Exception();
        }

        this.guesses = guesses;
        this.hints = hints;
    }

    public List<SymbolPeg> getGuesses() {
        return this.guesses;
    }

    public List<KeyPeg> getHint() {
        return this.hints;
    }

    public void setHint(List<KeyPeg> hint) {
        this.hints = hint;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null || obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Row row = (Row) obj;

        return this.getGuesses().equals(row.getGuesses());
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();

        for (SymbolPeg peg : guesses) {
            result.add(peg.getShortCode());
        }

        return String.join(" ", result);
    }
}
