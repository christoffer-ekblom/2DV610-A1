package Test.modelTest;

import Mastermind.model.*;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTest {

    private Opponent opponent;
    private Board board;
    private Game sut;

    @Before
    public void setUp() throws Exception {
        opponent = mock(Opponent.class);
        board = mock(Board.class);
        sut = new Game(opponent, board);
    }

    @Test
    public void shouldCallGenerateSecretCode() throws Exception {
        sut.newGame();

        verify(opponent).generateSecretCode();
    }

    @Test
    public void shouldReturnABoard() {
        Board actual = sut.getBoard();

        Assert.assertEquals(board, actual);
    }
}