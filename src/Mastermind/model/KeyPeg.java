package Mastermind.model;

public enum KeyPeg {
    Black("◙"),
    White("○");

    private String shortName;

    KeyPeg(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return this.shortName;
    }
}
