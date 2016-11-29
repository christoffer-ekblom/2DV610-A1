package Mastermind.controller;

import Mastermind.model.*;
import Mastermind.view.*;

import java.util.Scanner;

public class MasterController {

    private MainView view;
    private Game game;

    public MasterController(MainView view, Game game) {
        this.view = view;
        this.game = game;
    }

    public void run() throws Exception {
        this.view.showWelcomeMessage();

        playGame();

        this.view.showQuitMessage();
    }

    public void playGame() throws Exception {
        Row row;
        this.game.newGame();
        Opponent opponent = this.game.getOpponent();

        while (!isGameOver()) {
            this.view.showBoard(this.game.getBoard());
            this.view.showInstructions();

            row = view.getUserGameInput(new Scanner(System.in));
            this.game.getBoard().addGuessToBoard(row);

            if (opponent.checkGuess(row)) {
                this.view.showCongratulations();
                break;
            }
        }

        this.view.showBoard(this.game.getBoard());
    }

    public boolean isGameOver() {
        return game.getBoard().getGuessHistory().size() >= Board.DEFAULT_TABLE_LENGTH;
    }
}
