package Mastermind.model;

import java.util.ArrayList;
import java.util.List;

public enum SymbolPeg {
    Diamond("d", 0),
    Heart("h", 1),
    Club("c", 2),
    Spade("s", 3),
    King("k", 4),
    Queen("q", 5),
    Bishop("b", 6),
    Rook("r", 7);

    private final String shortCode;
    private final int value;

    SymbolPeg(String shortCode, int value) {
        this.shortCode = shortCode;
        this.value = value;
    }

    public static SymbolPeg getByValue(int index) throws Exception {
        for (SymbolPeg peg : SymbolPeg.values()) {
            if (peg.value == index) {
                return peg;
            }
        }

        throw new Exception();
    }

    public static List<SymbolPeg> getByInteger(List<Integer> ints) throws Exception {
        List<SymbolPeg> pegs = new ArrayList<>();

        for (int value : ints) {
            pegs.add(getByValue(value));
        }

        return pegs;
    }

    public static List<SymbolPeg> getByString(String str) throws Exception {
        List<SymbolPeg> symbolPegs = new ArrayList<>();

        if (!isValidUserInput(str)) {
            throw new Exception();
        }

        for (char character : str.toCharArray()) {
            for (SymbolPeg symbolPeg : SymbolPeg.values()) {
                if (character == symbolPeg.toString().toLowerCase().charAt(0)) {
                    symbolPegs.add(symbolPeg);
                }
            }
        }

        return symbolPegs;
    }

    public static boolean isValidUserInput(String input) {
        if (input.length() != Board.DEFAULT_ROW_LENGTH) {
            return false;
        }

        String validCharacters = "";

        for (SymbolPeg symbolPeg : SymbolPeg.values()) {
            validCharacters += symbolPeg.name().toLowerCase().charAt(0);
        }

        validCharacters = "^[" + validCharacters + "]+$";

        return input.matches(validCharacters);
    }

    public String getShortCode() {
        return shortCode;
    }
}
