package Mastermind;

import Mastermind.controller.*;

public class Mastermind {

    private PlayGame game;

    public Mastermind(PlayGame game) {
        this.game = game;
    }

    public static void main(String[] a_args) {
        Mastermind mastermind = new Mastermind(new PlayGame());

        mastermind.initialize();
    }

    public void initialize() {
        this.game.run();
    }
}
