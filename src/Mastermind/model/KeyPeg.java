package Mastermind.model;

public enum KeyPeg {
    Black("b"),
    White("w");

    private String shortName;

    KeyPeg(String shortName) {
        this.shortName = shortName;
    }

    public String toShortString() {
        return this.shortName;
    }
}
