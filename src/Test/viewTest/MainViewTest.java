package Test.viewTest;

import Mastermind.view.*;

import org.junit.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

public class MainViewTest {

    private MainView sut;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        sut = new MainView(printStream);
    }

    @Test
    public void shouldShowMainMenu() {
        sut.showMainMenu();

        verify(printStream).println(sut.MENU);
    }

    @Test
    public void shouldShowQuitMessage() {
        sut.showQuitMessage();

        verify(printStream).println(sut.QUIT);
    }
}
