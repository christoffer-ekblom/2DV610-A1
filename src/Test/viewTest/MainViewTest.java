package Test.viewTest;

import Mastermind.view.*;

import org.junit.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

public class MainViewTest {

    private MainView sut;

    @Before
    public void setUp() {

    }

    @Test
    public void shouldShowMainMenu() {
        PrintStream printStream = mock(PrintStream.class);
        sut = new MainView(printStream);

        sut.showMainMenu();

        verify(printStream).println(sut.MENU);
    }
}
