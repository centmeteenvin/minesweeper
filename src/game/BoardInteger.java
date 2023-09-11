package game;

public class BoardInteger extends Board<Integer> {

    @Override
    public Block<Integer> relativeTo(Block<Integer> block, int deltaX, int deltaY) {
        Coordinate<Integer> coordinate = block.getCoordinate();
        int newX = coordinate.getX() + deltaX;
        int newY = coordinate.getY() + deltaY;
        if (!blocks.containsKey(newY))
            return null;
        if (!blocks.get(newY).containsKey(newX))
            return null;
        return blocks.get(newY).get(newX);
    }
}
