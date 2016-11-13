package Mastermind.model;

public class Opponent {
    private int rowLength;

    public Opponent(int rowLength) throws Exception {
        if(rowLength == 0) {
            throw new Exception();
        }
        
        this.rowLength = rowLength;
    }

    public int getRowLength() {
        return this.rowLength;
    }
}
