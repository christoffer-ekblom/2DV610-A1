package Mastermind.controller;

import Mastermind.model.*;
import Mastermind.view.*;

import java.util.ArrayList;
import java.util.List;
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
        game.newGame();
        Opponent opponent = game.getOpponent();
        List<Row> guessHistory = new ArrayList<>();
        boolean isGameOver = false;
        boolean isCorrectGuess = false;

        while (!isGameOver) {
            isGameOver = guessHistory.size() >= Board.DEFAULT_TABLE_LENGTH;
            this.view.showBoard(this.game.getBoard());

            if (isCorrectGuess) {
                this.view.showCongratulations();
                break;
            }

            if(!isGameOver) {
                this.view.showInstructions();
                row = view.getUserGameInput(new Scanner(System.in));

                isCorrectGuess = opponent.checkGuess(row);

                this.game.getBoard().addGuessToBoard(row);
                guessHistory = this.game.getBoard().getGuessHistory();
            }
        }
    }
}
