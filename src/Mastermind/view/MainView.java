package Mastermind.view;

import Mastermind.model.*;

import java.io.PrintStream;
import java.util.*;

public class MainView {

    private PrintStream out;

    public final static String WELCOME = "Welcome to a game of Mastermind";
    public final static String INSTRUCTIONS = MainView.menuText();
    public final static String QUIT = "Thank you for playing Mastermind and welcome back anytime";
    public final static String CONGRATS = "Well done! You found the secret code :)";

    public MainView(PrintStream output) {
        this.out = output;
    }

    public void showWelcomeMessage() {
        out.println(this.WELCOME);
    }

    public void showInstructions() {
        out.println(this.INSTRUCTIONS);
    }

    public void showBoard(Board board) {
        out.println(getBoardGraphics(board));
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
            result.add("_ _ _ _"); // TODO: same number of "_" as DEFAULT_ROW_LENGTH
        }

        result.add("? ? ? ?"); // TODO: same number of "?" as DEFAULT_ROW_LENGTH

        Collections.reverse(result);

        return String.join("\n", result);
    }

    private static String menuText() {
        String output = "\nInstructions:\nEnter your guess. For example: \"dhcs\".\n";

        List<String> shortcuts = new ArrayList<>();
        String shortcut;
        List<String> symbolName = new ArrayList<>();

        for (SymbolPeg symbolPeg : SymbolPeg.values()) {
            shortcut = symbolPeg.name().toLowerCase().charAt(0) + "";
            shortcuts.add(shortcut);
            symbolName.add("(" + shortcut + ")" + symbolPeg.name().substring(1));
        }

        output += String.join(" ,", symbolName);
        output += "\n";

        return output;
    }

    public Row getUserGameInput(Scanner sc) throws Exception {
        String value;

        do {
            value = sc.nextLine();
        } while (!SymbolPeg.isValidUserInput(value));

        return new Row(SymbolPeg.getByString(value));
    }

    public void showCongratulations() {
        out.println(this.CONGRATS);
    }
}
