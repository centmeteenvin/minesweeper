package game;

public abstract class Block {
    private final Coordinate coordinate;

    protected Block(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
