package game;

public abstract class Rules {

    protected Board<?> board;

    void setBoard(Board<?> board) {
        this.board = board;
    }

    abstract <T> void calculate();
}
