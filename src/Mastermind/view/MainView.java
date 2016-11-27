package Mastermind.view;

import Mastermind.model.*;

import java.io.PrintStream;
import java.util.*;

public class MainView {

    private PrintStream out;

    public final static String MENU = "Welcome to a game of Mastermind\n\nInstructions:\nEnter your guess by typing \"rgby\" for (r)ed, (g)reen, (b)lue and (y)ellow.";
    public final static String QUIT = "Thank you for playing Mastermind and welcome back anytime";

    public MainView(PrintStream output) {
        this.out = output;
    }

    public void showMainMenu() {
        out.println(this.MENU);
    }

    public void showQuitMessage() {
        out.println(this.QUIT);
    }

    public String getBoardGraphics(Board board) {
        List<String> result = new ArrayList<>();

        for (Row guess : board.getGuessHistory()) {
            result.add(guess.toString());
        }

        while (result.size() < Board.DEFAULT_TABLE_LENGTH) {
            result.add("_ _ _ _");
        }

        result.add("? ? ? ?");

        Collections.reverse(result);

        return String.join("\n", result);
    }
}
