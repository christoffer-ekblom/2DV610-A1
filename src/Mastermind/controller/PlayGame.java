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
        this.view.showMainMenu();

        this.view.showQuitMessage();
    }
}
