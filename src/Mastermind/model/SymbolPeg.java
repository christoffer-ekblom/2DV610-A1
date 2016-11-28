package Mastermind.model;

import java.util.ArrayList;
import java.util.List;

public enum SymbolPeg {

    Diamond("d", 0),
    Heart("h", 1),
    Club("c", 2),
    Spade("s", 3);

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
        throw new Exception();
    }

    public String getShortCode() {
        return shortCode;
    }
}
