package Mastermind;

import Mastermind.controller.*;
import Mastermind.model.*;
import Mastermind.view.*;

public class Mastermind {

    private PlayGame playGame;

    public Mastermind(PlayGame game) {
        this.playGame = game;
    }

    public static void main(String[] a_args) {
        MainView view = new MainView(System.out);
        Opponent opponent = new Opponent();
        Board board = new Board();
        Game game = new Game(opponent, board);
        PlayGame playGame = new PlayGame(view, game);
        Mastermind mastermind = new Mastermind(playGame);

        mastermind.initialize();
    }

    public void initialize() {
        this.playGame.run();
    }
}
