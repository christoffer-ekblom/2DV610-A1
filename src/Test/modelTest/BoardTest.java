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
    public void shouldInstantiateWithDefaultTableLength() throws Exception {
        Field field = sut.getClass().getDeclaredField("guessHistory");
        field.setAccessible(true);

        Assert.assertEquals(Board.DEFAULT_TABLE_LENGTH, ((List<Row>)field.get(sut)).size());
    }

    @Test
    public void shouldGetGuessHistory() {
        List<Row> actual = sut.getGuessHistory();

        Assert.assertNotNull(actual);
    }
}
