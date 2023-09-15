package game;

public abstract class Visuals {
    protected Board board;
    protected Game game;

    public abstract void draw();

    public void setGame(Game game) {
        this.game = game;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
