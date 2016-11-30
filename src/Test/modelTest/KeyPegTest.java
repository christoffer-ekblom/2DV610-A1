package Test.modelTest;

import Mastermind.model.KeyPeg;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KeyPegTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturnShortName() {
        KeyPeg sut = KeyPeg.Black;

        String actual = sut.toShortString();
        String expected = "◙";

        Assert.assertEquals(expected, actual);
    }
}
