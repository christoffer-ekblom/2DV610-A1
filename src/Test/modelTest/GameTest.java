package Test.modelTest;

import Mastermind.model.*;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldCallGenerateSecretCode() throws Exception {
        Opponent opponent = mock(Opponent.class);
        Board board = mock(Board.class);
        Game sut = new Game(opponent, board);

        sut.newGame();

        verify(opponent).generateSecretCode();
    }

    @Test
    public void shouldReturnABoard() {
        Opponent opponent = mock(Opponent.class);
        Board board = mock(Board.class);
        Game sut = new Game(opponent, board);

        Board actual = sut.getBoard();

        Assert.assertEquals(board, actual);
    }
}