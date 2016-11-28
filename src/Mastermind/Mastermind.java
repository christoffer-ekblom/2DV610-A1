package Mastermind;

import Mastermind.controller.*;
import Mastermind.model.*;
import Mastermind.view.*;

public class Mastermind {

    private MasterController controller;

    public Mastermind(MasterController game) {
        this.controller = game;
    }

    public static void main(String[] a_args) throws Exception {
        MainView view = new MainView(System.out);
        Opponent opponent = new Opponent();
        Board board = new Board();
        Game game = new Game(opponent, board);
        MasterController controller = new MasterController(view, game);
        Mastermind mastermind = new Mastermind(controller);

        mastermind.initialize();
    }

    public void initialize() throws Exception {
        this.controller.run();
    }
}
