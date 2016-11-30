package Test.modelTest;

import Mastermind.model.SymbolPeg;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class SymbolPegTest {

    @Test
    public void shouldThrowExceptionWhenInvalidInput() {
        int tooLargeNumber = 10000;

        try {
            SymbolPeg.getByValue(tooLargeNumber);
            fail();
        } catch (Exception e) {
            //ok
        }

    }

    @Test
    public void shouldReturnCorrectSymbolPeg() throws Exception {
        SymbolPeg expected = SymbolPeg.Club;
        SymbolPeg actual = SymbolPeg.getByValue(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnListOfSymbolPegs() throws Exception {
        List<SymbolPeg> expected = new ArrayList<>();
        expected.add(SymbolPeg.Diamond);
        expected.add(SymbolPeg.Heart);
        expected.add(SymbolPeg.Club);
        expected.add(SymbolPeg.Spade);

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(0);
        ints.add(1);
        ints.add(2);
        ints.add(3);

        List<SymbolPeg> actual = SymbolPeg.getByInteger(ints);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectShortValue() {
        String expected = "c";
        String actual = SymbolPeg.Club.getshortcode();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfInputIsNull() {
        try {
            SymbolPeg.getByString(null);
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldThrowExceptionIfInputIsEmpty() {
        try {
            SymbolPeg.getByString("");
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldThrowExceptionIfInputContainsTooManyCharacters() {
        try {
            SymbolPeg.getByString("dhcsd");
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldThrowExceptionIfInputContainsTooFewCharacters() {
        try {
            SymbolPeg.getByString("dhc");
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldThrowExceptionIfInputContainsInvalidCharacters() {
        try {
            SymbolPeg.getByString("dhca");
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldGetCorrectListOfSymbolPegs() throws Exception {
        List<SymbolPeg> expected = new ArrayList<>();
        expected.add(SymbolPeg.Diamond);
        expected.add(SymbolPeg.Heart);
        expected.add(SymbolPeg.Heart);
        expected.add(SymbolPeg.Club);

        String str = "dhhc";

        List<SymbolPeg> actual = SymbolPeg.getByString(str);

        Assert.assertEquals(expected, actual);
    }
}
