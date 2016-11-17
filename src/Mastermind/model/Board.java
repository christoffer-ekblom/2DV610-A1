package Mastermind.model;

public class Board {
    public static final int MINIMUM_ROW_LENGTH = 1;
    public static final int MAXIMUM_ROW_LENGTH = 10;
    public static final int DEFAULT_ROW_LENGTH = 4;

    private int rowLength;

    public Board(int rowLength) {
        this.rowLength = rowLength;
    }

    public int getRowLength() {
        return this.rowLength;
    }
}
