package Mastermind.model;

public class Game {

    private final Opponent opponent;
    private final Board board;

    public Game(Opponent opponent) {
        this.opponent = opponent;
        board = new Board(Board.DEFAULT_ROW_LENGTH);
    }

    public void newGame() throws Exception {
        opponent.generateSecretCode();
    }
}
