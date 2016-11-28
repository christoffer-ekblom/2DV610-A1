package Test.modelTest;

import Mastermind.model.KeyPeg;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.*;

public class KeyPegTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturnShortName() {
        KeyPeg sut = KeyPeg.Black;

        String actual = sut.toShortString();
        String expected = "b";

        Assert.assertEquals(expected, actual);
    }
}