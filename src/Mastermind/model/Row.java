package Mastermind.model;

import java.util.ArrayList;
import java.util.Comparator;
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

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Row row = (Row) obj;

        return this.getGuesses().equals(row.getGuesses());
    }

    @Override
    public String toString() {
        List<String> guesses = new ArrayList<>();
        List<String> hints = new ArrayList<>();

        for (SymbolPeg peg : this.guesses) {
            guesses.add(peg.getShortCode());
        }

        String result = String.join(" ", guesses);

        if (this.hints.size() > 0) {
            for (KeyPeg peg : this.hints) {
                hints.add(peg.toShortString());
            }

            hints.sort(Comparator.reverseOrder());

            result += " → ";
            result += String.join(" ", hints);
        }

        return result;
    }
}
