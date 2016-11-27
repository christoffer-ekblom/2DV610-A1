package Test.modelTest;

import Mastermind.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Field;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OpponentTest {

    Opponent sut;

    @Before
    public void setUp() {
        sut = new Opponent();
    }

    @Test
    public void shouldFailIfTheOpponentHasTheWrongRowLength() throws Exception {
        int rowLength = 4;
        sut = new Opponent(rowLength);
        Assert.assertEquals(rowLength, sut.getRowLength());
    }

    @Test
    public void shouldFailIfTheDefaultRowLengthIsNotSet() throws Exception {
        boolean rowLengthIsNotSet = sut.getRowLength() == 0;
        Assert.assertFalse(rowLengthIsNotSet);
    }

    @Test
    public void shouldThrowExceptionIfTheOpponentHasTooSmallRowLength() throws Exception {
        int rowLength = 0;

        try {
            sut = new Opponent(rowLength);
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldThrowExceptionIfTheOpponentHasTooLargeRowLength() throws Exception {
        int rowLength = 20;

        try {
            sut = new Opponent(rowLength);
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldGetDifferentHints() throws Exception {
        Row row = mock(Row.class);
        List<List<KeyPeg>> hintHistory = new ArrayList<>();

        // should definitely give us different hints after 100 iterations
        for (int i = 0; i < 100; i++) {
            sut.generateSecretCode();
            sut.checkGuess(row);
            hintHistory.add(sut.getHint());
        }

        List<Boolean> isSame = new ArrayList<>();

        for (List<KeyPeg> hint : hintHistory) {
            for (int i = 0; i < hintHistory.size(); i++) {
                isSame.add(hint.equals(hintHistory.get(i)));
            }
        }

        boolean containsFalse = isSame.contains(false);

        Assert.assertTrue(containsFalse);
    }

    @Test
    public void shouldGenerateNotNullSecretCode() throws Exception {
        sut.generateSecretCode();
        Field field = Opponent.class.getDeclaredField("secretCode");
        field.setAccessible(true);
        Row row = (Row) field.get(sut);
        Assert.assertNotNull(row);
    }

    @Test
    public void shouldGenerateDifferentSecretCodes() throws Exception {
        Field field = Opponent.class.getDeclaredField("secretCode");
        field.setAccessible(true);
        Row rowTest;

        sut.generateSecretCode();
        Row firstRow = (Row) field.get(sut);
        int counter = 0;

        do {
            sut.generateSecretCode();
            rowTest = (Row) field.get(sut);

            if (counter++ >= 100) {
                fail();
            }
        } while (rowTest.equals(firstRow));
    }

    @Test
    public void shouldThrowExceptionIfNullRow() {
        try {
            sut.checkGuess(null);
            fail();
        } catch (Exception e) {
            // Ok
        }
    }

    @Test
    public void shouldThrowExceptionIfEmptyRow() {
        try {
            sut.checkGuess(new Row());
            fail();
        } catch (Exception e) {
            // Ok
        }
    }

    @Test
    public void shouldGenerateOneBlackPeg() throws Exception {
        Row guess = spy(Row.class);

        List<SymbolPeg> guesses = new ArrayList<>(Arrays.asList(SymbolPeg.Diamond, SymbolPeg.Heart, SymbolPeg.Heart, SymbolPeg.Heart));
        List<SymbolPeg> secrets = new ArrayList<>(Arrays.asList(SymbolPeg.Diamond, SymbolPeg.Club, SymbolPeg.Club, SymbolPeg.Club));
        List<KeyPeg> expected = new ArrayList<>(Arrays.asList(KeyPeg.Black));

        when(guess.getSymbolPegs()).thenReturn(guesses);

        Field field = Opponent.class.getDeclaredField("secretCode");
        field.setAccessible(true);
        field.set(sut, new Row(secrets));

        sut.checkGuess(guess);

        List<KeyPeg> actual = guess.getKeyPegs();

        Assert.assertEquals(expected, actual);
    }
}
