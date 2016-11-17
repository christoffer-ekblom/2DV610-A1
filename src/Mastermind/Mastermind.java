package Mastermind;

import Mastermind.controller.*;
import Mastermind.view.*;

public class Mastermind {

    private PlayGame game;

    public Mastermind(PlayGame game) {
        this.game = game;
    }

    public static void main(String[] a_args) {
        IView view = new MainView(System.out);
        PlayGame playGame = new PlayGame(view);
        Mastermind mastermind = new Mastermind(playGame);

        mastermind.initialize();
    }

    public void initialize() {
        this.game.run();
    }
}
