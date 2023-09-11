package game;

public class GameFactory {
    public static Game create() {
        Board board = new Board();
        Rules rules = new RulesNormal();
        board.setRules(rules);
        rules.setBoard(board);
        return new Game(board, rules);
    }
}
