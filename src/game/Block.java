package game;

public abstract class Block<T> {
    private final Coordinate<T> coordinate;

    protected Block(Coordinate<T> coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate<T> getCoordinate() {
        return coordinate;
    }
}
