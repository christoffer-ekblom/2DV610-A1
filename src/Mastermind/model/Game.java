package Mastermind.model;

public class Game {

    private final Opponent opponent;
    private final Board board;

    public Game(Opponent opponent, Board board) {
        this.opponent = opponent;
        this.board = board;
    }

    public void newGame() throws Exception {
        opponent.generateSecretCode();
    }

    public Board getBoard() {
        return this.board;
    }

    public boolean isGameOver() {
        return false;
    }
}
