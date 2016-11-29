package Test.modelTest;

import Mastermind.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class RowTest {

    Row row;
    List<SymbolPeg> symbolPegs;
    List<KeyPeg> keyPegs;

    @Before
    public void setUp() throws Exception {
        List<SymbolPeg> symbolPegs = new ArrayList<>();
        symbolPegs.add(SymbolPeg.Spade);
        symbolPegs.add(SymbolPeg.Club);
        symbolPegs.add(SymbolPeg.Diamond);
        symbolPegs.add(SymbolPeg.Heart);

        this.symbolPegs = symbolPegs;

        List<KeyPeg> keyPegs = new ArrayList<>();
        keyPegs.add(KeyPeg.Black);
        keyPegs.add(KeyPeg.Black);
        keyPegs.add(KeyPeg.White);

        this.keyPegs = keyPegs;

        this.row = new Row(symbolPegs, keyPegs);
    }

    @Test
    public void shouldReturnSameListOfSymbolPegsAsWeCalledFromConstructor() {
        List<SymbolPeg> expected = this.symbolPegs;
        List<SymbolPeg> actual = row.getGuesses();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorShouldWorkWithOnlyFirstArgument() throws Exception {
        Row row = new Row(this.symbolPegs);
        List<SymbolPeg> expected = this.symbolPegs;
        List<SymbolPeg> actual = row.getGuesses();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowAnExceptionIfSymbolPegIsEmpty() {
        try {
            new Row(new ArrayList<>(), this.keyPegs);
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldReturnSameListOfKeyPegsAsWeCalledFromConstructor() {
        List<KeyPeg> expected = this.keyPegs;
        List<KeyPeg> actual = row.getHint();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDisplayCorrectStringRepresentation() throws Exception {
        Row sut = new Row(symbolPegs);

        String actual = sut.toString();
        String expected = "s c d h";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDisplayCorrectStringRepresentationWithHints() throws Exception {
        Row sut = new Row(symbolPegs, keyPegs);

        String actual = sut.toString();
        String expected = "s c d h → ◙ ◙ ○";

        Assert.assertEquals(expected, actual);
    }
}
