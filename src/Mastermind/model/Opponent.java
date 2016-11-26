package Mastermind.model;

import Mastermind.model.Board;

import java.util.*;

public class Opponent {

    private int rowLength;

    public Opponent() {
        this.rowLength = Board.DEFAULT_ROW_LENGTH;
    }

    public Opponent(int rowLength) throws Exception {
        if(rowLength < Board.MINIMUM_ROW_LENGTH || rowLength > Board.MAXIMUM_ROW_LENGTH) {
            throw new Exception();
        }

        this.rowLength = rowLength;
    }

    public int getRowLength() {
        return this.rowLength;
    }

    public void generateSecretCode() {

    }

    public void checkGuess(Row guess) {

    }

    public List<KeyPeg> getHint() {
        List<KeyPeg> keyPeg = new LinkedList<KeyPeg>();
        Random random = new Random();
        int num;

        for(int i = 0; i < rowLength; i++) {
            num = random.nextInt(2);
            if(num == 0) {
                keyPeg.add(KeyPeg.Black);
            }
            else {
                keyPeg.add(KeyPeg.White);
            }
        }

        return keyPeg;
    }
}
