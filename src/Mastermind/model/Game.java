package Mastermind.model;

public class Game {

    private final Opponent opponent;
    private final Board board;

    public Game(Opponent opponent) {
        this.opponent = opponent;
        board = new Board();
    }

    public void newGame() throws Exception {
        opponent.generateSecretCode();
    }
}
