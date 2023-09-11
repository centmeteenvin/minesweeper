package game;

public class Game {
    final Board board;
    final Rules rules;

    public Game(Board board, Rules rules) {
        this.board = board;
        this.rules = rules;
    }
}
