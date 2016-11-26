package Test.modelTest;

import Mastermind.model.SymbolPeg;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SymbolPegTest {
    @Test
    public void shouldThrowExceptionWhenInvalidInput() {
        int tooLargeNumber = 10000;

        try {
            SymbolPeg.getByValue(tooLargeNumber);
            fail();
        }
        catch (Exception e) {
            //ok
        }

    }

    @Test
    public void shouldReturnCorrectSymbolPeg() throws Exception {
        SymbolPeg expected = SymbolPeg.Club;
        SymbolPeg actual = SymbolPeg.getByValue(2);

        Assert.assertEquals(expected, actual);
    }
}