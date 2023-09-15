package game;

public class OutOfBoundsException extends Exception {
    public final Coordinate coordinate;
    public final int maxX;
    public final int maxY;

    public OutOfBoundsException(Coordinate coordinate, int maxX, int maxY) {
        super("bitch you wrong!!!");
        this.coordinate = coordinate;
        this.maxX = maxX;
        this.maxY = maxY;
    }
}
