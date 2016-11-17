package Test.modelTest;

import Mastermind.model.*;

import org.junit.*;

public class BoardTest {

    private Board sut;

    @Before
    public void setUp() {

    }

    @Test
    public void shouldReturnCorrectRowLength() {
        int expected = 7;

        sut = new Board(expected);

        int actual = sut.getRowLength();

        Assert.assertEquals(actual, expected);
    }
}
