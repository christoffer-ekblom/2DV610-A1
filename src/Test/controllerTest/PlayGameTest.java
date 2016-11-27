package Test.controllerTest;

import Mastermind.controller.*;
import Mastermind.model.*;
import Mastermind.view.*;

import org.junit.*;

import static org.mockito.Mockito.*;

public class PlayGameTest {

    @Before
    public void setUp() {
        // Empty
    }

    @Test
    public void shouldShowWelcomeMessageInstructionsAndQuit() {
        MainView view = mock(MainView.class);
        Game game = mock(Game.class);
        PlayGame sut = new PlayGame(view, game);

        sut.run();

        verify(view).showWelcomeMessage();
        verify(view).showBoard(game.getBoard());
        verify(view).showInstructions();
        verify(view).showQuitMessage();
    }
}
