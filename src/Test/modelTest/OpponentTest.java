package Test.modelTest;

import Mastermind.model.Opponent;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpponentTest {

    private Opponent opponent;

    @Test
    public void shouldFailIfTheOpponentHasTheWrongRowLength() {
        int rowLength = 4;
        opponent = new Opponent(rowLength);
        Assert.assertEquals(rowLength, opponent.getRowLength());
    }
}
