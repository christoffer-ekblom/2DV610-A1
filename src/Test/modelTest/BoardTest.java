package Test.modelTest;

import Mastermind.model.*;

import org.junit.*;

import java.lang.reflect.Field;
import java.util.List;

public class BoardTest {

    private Board sut;

    @Before
    public void setUp() {
        sut = new Board();
    }

    @Test
    public void shouldInstantiateWithZeroLength() throws Exception {
        Field field = sut.getClass().getDeclaredField("guessHistory");
        field.setAccessible(true);

        Assert.assertEquals(0, ((List<Row>)field.get(sut)).size());
    }

    @Test
    public void shouldGetGuessHistory() {
        List<Row> actual = sut.getGuessHistory();

        Assert.assertNotNull(actual);
    }
}
