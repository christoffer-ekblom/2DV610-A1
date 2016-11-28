package Test.controllerTest;

import Mastermind.controller.*;
import Mastermind.model.*;
import Mastermind.view.*;

import org.junit.*;

import static org.mockito.Mockito.*;

public class MasterControllerTest {

    @Before
    public void setUp() {
        // Empty
    }

    @Test
    public void shouldShowWelcomeMessageInstructionsAndQuit() throws Exception {
        MainView view = mock(MainView.class);
        Game game = mock(Game.class);
        Opponent opponent = mock(Opponent.class);
        MasterController sut = new MasterController(view, game);

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
        MainView view = mock(MainView.class);
        Game game = mock(Game.class);
        Opponent opponent = mock(Opponent.class);
        MasterController sut = new MasterController(view, game);

        when(game.getBoard()).thenReturn(new Board());
        when(game.getOpponent()).thenReturn(opponent);
        when(opponent.checkGuess(new Row())).thenReturn(false);

        sut.playGame();

        verify(game).newGame();
    }
}
