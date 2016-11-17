package Mastermind.view;

import java.io.PrintStream;

public class MainView implements IView {

    private PrintStream out;

    public final static String MENU = "MENU";

    public MainView(PrintStream output) {
        this.out = output;
    }

    public void showMainMenu() {
        out.println(this.MENU);
    }
}
