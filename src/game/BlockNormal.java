package game;

public class BlockNormal extends Block {

    private int numberOfBombs;
    private boolean numberOfBombsIsSet = false;

    protected BlockNormal(Coordinate coordinate) {
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
