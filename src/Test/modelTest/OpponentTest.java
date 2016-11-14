package Test.modelTest;

import Mastermind.model.Opponent;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpponentTest {

    private Opponent opponent;
    private int notInitializedInteger;

    @Test
    public void shouldFailIfTheOpponentHasTheWrongRowLength() throws Exception {
        int rowLength = 4;
        opponent = new Opponent(rowLength);
        Assert.assertEquals(rowLength, opponent.getRowLength());
    }

    @Test
    public void shouldFailIfTheDefaultRowLengthIsNotSet() throws Exception {
        opponent = new Opponent();
        boolean rowLengthIsNotSet = opponent.getRowLength() == this.notInitializedInteger;
        Assert.assertFalse(rowLengthIsNotSet);
    }

    @Test
    public void shouldThrowExceptionIfTheOpponentHasTooSmallRowLength() throws Exception {
        int rowLength = 0;

        try {
            opponent = new Opponent(rowLength);
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldThrowExceptionIfTheOpponentHasTooLargeRowLength() throws Exception {
        int rowLength = 20;

        try {
            opponent = new Opponent(rowLength);
            fail();
        } catch (Exception e) {
            //ok
        }
    }
}
