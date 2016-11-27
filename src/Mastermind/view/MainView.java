package Mastermind.view;

import Mastermind.model.Board;

import java.io.PrintStream;

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

    public String getBoardGraphics() {
        String result =  "? ? ? ?";

        for (int i = 0; i < Board.DEFAULT_TABLE_LENGTH; i++) {
            result += "\n_ _ _ _";
        }

        return result;
    }
}
