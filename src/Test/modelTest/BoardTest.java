package Test.modelTest;

import Mastermind.model.*;

import org.junit.*;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        Assert.assertEquals(0, ((List<Row>) field.get(sut)).size());
    }

    @Test
    public void shouldGetGuessHistory() {
        List<Row> actual = sut.getGuessHistory();

        Assert.assertNotNull(actual);
    }

    @Test
    public void shouldGetSecretCodeFromOpponent() throws Exception {
        List<SymbolPeg> code = new LinkedList<>();
        code.add(SymbolPeg.Club);
        code.add(SymbolPeg.Club);
        code.add(SymbolPeg.Club);
        code.add(SymbolPeg.Club);

        Row expected = new Row(code);

        Opponent opponent = mock(Opponent.class);
        when(opponent.getSecretCodeAndChangeIt()).thenReturn(expected);

        Row actual = sut.getSecretCodeFromOpponent(opponent);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddGuessToBoard() {
        int expected = sut.getGuessHistory().size() + 1;

        sut.addGuessToBoard(new Row());

        int actual = sut.getGuessHistory().size();

        Assert.assertEquals(expected, actual);
    }
}
