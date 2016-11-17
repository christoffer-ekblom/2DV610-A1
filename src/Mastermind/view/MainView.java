package Mastermind.view;

import java.io.PrintStream;

public class MainView implements IView {

    private PrintStream out;

    public final static String MENU = "Mastermind Main Menu\n1. Start new game\n2. Settings\n3. Quit";

    public MainView(PrintStream output) {
        this.out = output;
    }

    public void showMainMenu() {
        out.println(this.MENU);
    }
}
