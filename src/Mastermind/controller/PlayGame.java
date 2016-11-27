package Mastermind.controller;

import Mastermind.model.*;
import Mastermind.view.*;

public class PlayGame {

    private MainView view;
    private Game game;

    public PlayGame(MainView view, Game game) {
        this.view = view;
        this.game = game;
    }

    public void run() throws Exception {
        this.view.showWelcomeMessage();

        playGame();

        this.view.showQuitMessage();
    }

    public void playGame() throws Exception {
        game.newGame();

        while (!game.isGameOver()) {
            this.view.showBoard(this.game.getBoard());
            this.view.showInstructions();

            //this.game.getBoard().addGuessToBoard(new Row());

            break;
        }
    }
}
