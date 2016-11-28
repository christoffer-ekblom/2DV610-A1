package Mastermind.model;

public enum KeyPeg {
    Black("◙"),
    White("○");

    private String shortName;

    KeyPeg(String shortName) {
        this.shortName = shortName;
    }

    public String toShortString() {
        return this.shortName;
    }
}
