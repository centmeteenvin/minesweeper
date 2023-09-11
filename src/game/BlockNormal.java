package game;

public class BlockNormal<T> extends Block<T> {

    private int numberOfBombs;
    private boolean numberOfBombsIsSet = false;

    protected BlockNormal(Coordinate<T> coordinate) {
        super(coordinate);
    }

    public void setNumberOfBombs(int numberOfBombs) {
        if (numberOfBombsIsSet)
            return;
        this.numberOfBombs = numberOfBombs;
        numberOfBombsIsSet = true;
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }
}
