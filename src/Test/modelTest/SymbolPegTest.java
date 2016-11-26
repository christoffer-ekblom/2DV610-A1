package Test.modelTest;

import Mastermind.model.SymbolPeg;
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
}