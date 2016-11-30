package Test.controllerTest;

import Mastermind.controller.*;
import Mastermind.model.*;
import Mastermind.view.*;

import org.junit.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class MasterControllerTest {

    private View view;
    private Game game;
    private Opponent opponent;
    private MasterController sut;
    private Board board;

    @Before
    public void setUp() {
        view = mock(View.class);
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

    @Test
    public void shouldShowCongratulationsOnFindingSecret() throws Exception {
        String input = "dcdh";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner sc = new Scanner(System.in);

        when(game.getOpponent()).thenReturn(opponent);
        when(view.getUserGameInput(sc)).thenReturn(new Row());
        when(game.getBoard()).thenReturn(board);
        when(board.getGuessHistory()).thenReturn(new ArrayList<>());
        when(opponent.checkGuess(null)).thenReturn(true);

        sut.playGame();

        verify(view).showCongratulations();
    }
}
