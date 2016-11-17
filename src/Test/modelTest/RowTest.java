package Test.modelTest;

import Mastermind.model.KeyPeg;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import Mastermind.model.SymbolPeg;
import Mastermind.model.Row;

public class RowTest {
    Row row;
    List<SymbolPeg> symbolPegs;
    List<KeyPeg> keyPegs;

    @Before
    public void setUp() throws Exception {
        List<SymbolPeg> symbolPegs = new LinkedList<SymbolPeg>();
        symbolPegs.add(SymbolPeg.King);
        symbolPegs.add(SymbolPeg.Queen);
        symbolPegs.add(SymbolPeg.Diamond);
        symbolPegs.add(SymbolPeg.Heart);

        this.symbolPegs = symbolPegs;

        List<KeyPeg> keyPegs = new LinkedList<KeyPeg>();
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
            new Row(new LinkedList<SymbolPeg>(), this.keyPegs);
            fail();
        }
        catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldReturnSameListOfKeyPegsAsWeCalledFromConstructor() {
        List<KeyPeg> expected = this.keyPegs;
        List<KeyPeg> actual = row.getKeyPegs();
        Assert.assertEquals(expected, actual);
    }
}
