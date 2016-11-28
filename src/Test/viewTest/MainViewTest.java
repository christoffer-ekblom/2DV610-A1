package Test.viewTest;

import Mastermind.model.Board;
import Mastermind.model.Row;
import Mastermind.model.SymbolPeg;
import Mastermind.view.*;

import org.junit.*;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainViewTest {
    private MainView sut;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        sut = new MainView(printStream);
    }

    @Test
    public void shouldShowWelcomeMessage() {
        sut.showWelcomeMessage();

        verify(printStream).println(sut.WELCOME);
    }

    @Test
    public void shouldShowBoard() {
        Board board = mock(Board.class);
        sut.showBoard(board);

        verify(printStream).println(sut.getBoardGraphics(board));
    }

    @Test
    public void shouldShowInstructions() {
        sut.showInstructions();

        verify(printStream).println(sut.INSTRUCTIONS);
    }

    @Test
    public void shouldShowQuitMessage() {
        sut.showQuitMessage();

        verify(printStream).println(sut.QUIT);
    }

    @Test
    public void shouldShowCongratsMessage() {
        sut.showCongratulations();

        verify(printStream).println(sut.CONGRATS);
    }

    @Test
    public void shouldDisplayEmptyBoard() {
        Board board = mock(Board.class);
        String actual = sut.getBoardGraphics(board);

        String expected = "? ? ? ?";

        for (int i = 0; i < Board.DEFAULT_TABLE_LENGTH; i++) {
            expected += "\n_ _ _ _";
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnARow() throws Exception {
        String input = "dcdh";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner sc = new Scanner(System.in);
        Row actual = sut.getUserGameInput(sc);
        Row expected = new Row(new ArrayList<>(Arrays.asList(SymbolPeg.Diamond, SymbolPeg.Club, SymbolPeg.Diamond, SymbolPeg.Heart)));

        Assert.assertEquals(expected, actual);
    }
}
