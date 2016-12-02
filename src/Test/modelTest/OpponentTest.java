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
        List<SymbolPeg> guesses = new ArrayList<>(Arrays.asList(SymbolPeg.Diamond, SymbolPeg.Heart, SymbolPeg.Heart, SymbolPeg.Heart));
        List<SymbolPeg> secrets = new ArrayList<>(Arrays.asList(SymbolPeg.Diamond, SymbolPeg.Club, SymbolPeg.Club, SymbolPeg.Club));
        List<KeyPeg> expected = new ArrayList<>(Arrays.asList(KeyPeg.Black));

        checkHint(guesses, secrets, expected);
    }

    @Test
    public void shouldGenerateOneBlackPeg2() throws Exception {
        List<SymbolPeg> guesses = new ArrayList<>(Arrays.asList(SymbolPeg.Diamond, SymbolPeg.Diamond, SymbolPeg.Diamond, SymbolPeg.Diamond));
        List<SymbolPeg> secrets = new ArrayList<>(Arrays.asList(SymbolPeg.Club, SymbolPeg.Diamond, SymbolPeg.Club, SymbolPeg.Club));
        List<KeyPeg> expected = new ArrayList<>(Arrays.asList(KeyPeg.Black));

        checkHint(guesses, secrets, expected);
    }

    @Test
    public void shouldGenerateOneWhitePeg() throws Exception {
        List<SymbolPeg> guesses = new ArrayList<>(Arrays.asList(SymbolPeg.Diamond, SymbolPeg.Heart, SymbolPeg.Heart, SymbolPeg.Heart));
        List<SymbolPeg> secrets = new ArrayList<>(Arrays.asList(SymbolPeg.Club, SymbolPeg.Diamond, SymbolPeg.Club, SymbolPeg.Club));
        List<KeyPeg> expected = new ArrayList<>(Arrays.asList(KeyPeg.White));

        checkHint(guesses, secrets, expected);
    }

    @Test
    public void shouldGenerateFourBlackPegs() throws Exception {
        List<SymbolPeg> secrets = new ArrayList<>(Arrays.asList(SymbolPeg.Diamond, SymbolPeg.Diamond, SymbolPeg.Diamond, SymbolPeg.Diamond));
        List<SymbolPeg> guesses = secrets;

        List<KeyPeg> expected = new ArrayList<>(Arrays.asList(KeyPeg.Black, KeyPeg.Black, KeyPeg.Black, KeyPeg.Black));

        checkHint(guesses, secrets, expected);
    }

    @Test
    public void shouldGenerateTwoBlackPegs() throws Exception {
        List<SymbolPeg> secrets = new ArrayList<>(Arrays.asList(SymbolPeg.Bishop, SymbolPeg.Rook, SymbolPeg.Bishop, SymbolPeg.Queen));
        List<SymbolPeg> guesses = new ArrayList<>(Arrays.asList(SymbolPeg.Bishop, SymbolPeg.Rook, SymbolPeg.Spade, SymbolPeg.Spade));

        List<KeyPeg> expected = new ArrayList<>(Arrays.asList(KeyPeg.Black, KeyPeg.Black));

        checkHint(guesses, secrets, expected);
    }

    @Test
    public void shouldReturnTrueIfGuessEqualsSecret() throws Exception {
        List<SymbolPeg> secrets = new ArrayList<>(Arrays.asList(SymbolPeg.Club, SymbolPeg.Diamond, SymbolPeg.Club, SymbolPeg.Club));
        List<SymbolPeg> guesses = new ArrayList<>(Arrays.asList(SymbolPeg.Club, SymbolPeg.Diamond, SymbolPeg.Club, SymbolPeg.Club));

        Field field = Opponent.class.getDeclaredField("secretCode");
        field.setAccessible(true);
        field.set(sut, new Row(secrets));

        Assert.assertTrue(sut.checkGuess(new Row(guesses)));

        List<KeyPeg> expected = new ArrayList<>(Arrays.asList(KeyPeg.Black, KeyPeg.Black, KeyPeg.Black, KeyPeg.Black));

        checkHint(guesses, secrets, expected);
    }

    @Test
    public void shouldGetSecretCodeAndChangeIt() throws Exception {
        List<SymbolPeg> secrets = new ArrayList<>(Arrays.asList(SymbolPeg.Club, SymbolPeg.Club, SymbolPeg.Club, SymbolPeg.Club));
        Row expected = new Row(secrets);

        Field field = Opponent.class.getDeclaredField("secretCode");
        field.setAccessible(true);
        field.set(sut, new Row(secrets));

        Row actual = sut.getSecretCodeAndChangeIt();

        Assert.assertEquals(expected, actual);

        Assert.assertNotEquals(expected, sut.getSecretCodeAndChangeIt());
    }

    private void checkHint(List<SymbolPeg> guesses, List<SymbolPeg> secrets, List<KeyPeg> expected) throws Exception {
        Row guess = spy(Row.class);

        when(guess.getGuesses()).thenReturn(guesses);

        Field field = Opponent.class.getDeclaredField("secretCode");
        field.setAccessible(true);
        field.set(sut, new Row(secrets));

        sut.checkGuess(guess);

        List<KeyPeg> actual = guess.getHint();

        Assert.assertEquals(expected, actual);
    }
}
