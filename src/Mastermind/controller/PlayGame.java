package Mastermind.controller;

import Mastermind.model.*;
import Mastermind.view.*;

import java.util.List;

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
        int i = 0;
        game.newGame();
        List<Row> guessHistory;

        while (!game.isGameOver()) {
            this.view.showBoard(this.game.getBoard());
            this.view.showInstructions();
            this.game.getBoard().addGuessToBoard(new Row());

            guessHistory = this.game.getBoard().getGuessHistory();

            if(guessHistory.size() == Board.DEFAULT_TABLE_LENGTH) {
                break;
            }
        }
    }
}
