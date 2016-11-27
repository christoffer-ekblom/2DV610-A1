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
        List<SymbolPeg> actual = row.getSymbolPegs();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorShouldWorkWithOnlyFirstArgument() throws Exception {
        Row row = new Row(this.symbolPegs);
        List<SymbolPeg> expected = this.symbolPegs;
        List<SymbolPeg> actual = row.getSymbolPegs();
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
        List<KeyPeg> actual = row.getKeyPegs();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDisplayCorrectStringRepresentation() throws Exception {
        List<SymbolPeg> pegs = new ArrayList<>(Arrays.asList(SymbolPeg.Heart, SymbolPeg.Club, SymbolPeg.Diamond, SymbolPeg.Spade));
        Row sut = new Row(pegs);

        String actual = sut.toString();
        String expected = "h c d s";

        Assert.assertEquals(expected, actual);
    }
}
