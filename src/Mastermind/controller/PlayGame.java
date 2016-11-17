package Mastermind.controller;

import Mastermind.view.IView;

public class PlayGame {

    private IView view;

    public PlayGame(IView view) {
        this.view = view;
    }

    public void run() {
        this.view.showMainMenu();

        this.view.showQuitMessage();
    }
}
