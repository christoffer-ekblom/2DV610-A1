package Mastermind.controller;

import Mastermind.model.*;
import Mastermind.view.*;

import java.util.ArrayList;
import java.util.List;

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
        game.newGame();
        List<Row> guessHistory = new ArrayList<>();

        while (guessHistory.size() != Board.DEFAULT_TABLE_LENGTH) {
            this.view.showBoard(this.game.getBoard());
            this.view.showInstructions();

            this.game.getBoard().addGuessToBoard(new Row()); // TODO: make a real user guess here insted of this line

            guessHistory = this.game.getBoard().getGuessHistory();
        }
    }
}
