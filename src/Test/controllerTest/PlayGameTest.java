package Test.controllerTest;

import Mastermind.controller.*;
import Mastermind.view.*;
import org.junit.*;

import static org.mockito.Mockito.*;

public class PlayGameTest {

    @Before
    public void setUp() {
        // Empty
    }

    @Test
    public void shouldShowMainMenu() {
        IView view = mock(MainView.class);
        PlayGame sut = new PlayGame(view);

        sut.run();

        verify(view).showMainMenu();
    }
}