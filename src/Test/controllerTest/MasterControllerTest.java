package Test.controllerTest;

import Mastermind.controller.*;
import Mastermind.model.*;
import Mastermind.view.*;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class MasterControllerTest {

    private MainView view;
    private Game game;
    private Opponent opponent;
    private MasterController sut;
    private Board board;

    @Before
    public void setUp() {
        view = mock(MainView.class);
        game = mock(Game.class);
        opponent = mock(Opponent.class);
        board = mock(Board.class);
        sut = new MasterController(view, game);
    }

    @Test
    public void shouldShowWelcomeMessageInstructionsAndQuit() throws Exception {
        when(game.getBoard()).thenReturn(new Board());
        when(game.getOpponent()).thenReturn(opponent);
        when(opponent.checkGuess(new Row())).thenReturn(false);

        sut.run();

        verify(view).showWelcomeMessage();
        verify(view, atLeast(1)).showBoard(game.getBoard());
        verify(view, atLeast(1)).showInstructions();
        verify(view, atLeast(1)).showQuitMessage();
    }

    @Test
    public void shouldExecuteNewGame() throws Exception {
        when(game.getBoard()).thenReturn(new Board());
        when(game.getOpponent()).thenReturn(opponent);
        when(opponent.checkGuess(new Row())).thenReturn(false);

        sut.playGame();

        verify(game).newGame();
    }

    @Test
    public void shouldReportGameAsOver() {
        when(game.getBoard()).thenReturn(board);
        when(board.getGuessHistory()).thenReturn(Arrays.asList(new Row[Board.DEFAULT_TABLE_LENGTH]));

        Assert.assertTrue(sut.isGameOver());
    }
}
