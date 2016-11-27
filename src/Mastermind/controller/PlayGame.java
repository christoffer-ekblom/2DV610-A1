package Mastermind.controller;

import Mastermind.view.*;

public class PlayGame {

    private MainView view;

    public PlayGame(MainView view) {
        this.view = view;
    }

    public void run() {
        this.view.showMainMenu();

        this.view.showQuitMessage();
    }
}
