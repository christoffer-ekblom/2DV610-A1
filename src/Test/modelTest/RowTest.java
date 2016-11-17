package Test.modelTest;

import Mastermind.model.KeyPeg;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

import Mastermind.model.SymbolPeg;
import Mastermind.model.Row;

public class RowTest {
    @Test
    public void shouldReturnSameListOfSymbolPegsAsWeCalledFromConstructor() {
        List<SymbolPeg> expected = new LinkedList<SymbolPeg>();
        expected.add(SymbolPeg.King);
        expected.add(SymbolPeg.Queen);
        expected.add(SymbolPeg.Diamond);
        expected.add(SymbolPeg.Heart);

        List<KeyPeg> keyPegs = new LinkedList<KeyPeg>();

        Row row = new Row(expected, keyPegs);

        List<SymbolPeg> actual = row.getSymbolPegs();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSameListOfKeyPegsAsWeCalledFromConstructor() {
        List<SymbolPeg> symbolPegs = new LinkedList<SymbolPeg>();

        List<KeyPeg> expected = new LinkedList<KeyPeg>();
        expected.add(KeyPeg.Black);
        expected.add(KeyPeg.Black);
        expected.add(KeyPeg.White);

        Row row = new Row(symbolPegs, expected);

        List<KeyPeg> actual = row.getKeyPegs();

        Assert.assertEquals(expected, actual);
    }
}
