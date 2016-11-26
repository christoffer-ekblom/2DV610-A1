package Mastermind.model;

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
        if(index >= SymbolPeg.values().length) {
            throw new Exception();
        }

        return SymbolPeg.Diamond;
    }
}
