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

    public void run() {
        this.view.showWelcomeMessage();
        this.view.showBoard(this.game.getBoard());
        this.view.showInstructions();

        while (playGame());

        this.view.showQuitMessage();
    }

    public boolean playGame() {
        return false;
    }
}
