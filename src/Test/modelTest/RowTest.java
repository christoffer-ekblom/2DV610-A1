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
}
