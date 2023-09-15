package game;

import java.util.*;

public class Board {
    private final Map<Integer, Map<Integer, Block>> blocks = new HashMap<>();
    private Rules rules;
    private final int numberOfBombs;

    public Board(int width, int height, int numberOfBombs) {
        this.numberOfBombs = numberOfBombs;
        for (int row = 1; row <= height; row++) {
            Map<Integer, Block> map = new HashMap<>();
            for (int column = 1; column <= height; column++) {
                map.put(column, null);
            }
            blocks.put(row, map);
        }
    }

    public Block relativeTo(Block block, int deltaX, int deltaY) {
        Coordinate coordinate = block.getCoordinate();
        int newX = coordinate.x() + deltaX;
        int newY = coordinate.y() + deltaY;
        if (!blocks.containsKey(newY))
            return null;
        if (!blocks.get(newY).containsKey(newX))
            return null;
        return blocks.get(newY).get(newX);
    }

    public void placeBombs(List<Coordinate> forbiddenCoordinates) {
        int bombsPlaced = 0;
        Random random = new Random();
        while (bombsPlaced < numberOfBombs) {
            int x = random.nextInt(1, getWidth()+1);
            int y = random.nextInt(1, getHeight()+1);
            Coordinate coordinate = new Coordinate(x,y);
            Block block = get(x,y);
            if (block == null && !forbiddenCoordinates.contains(coordinate)){
                blocks.get(y).put(x, new BlockBomb(coordinate));
                bombsPlaced++;
            }
        }
    }

    public void placeBlocks() {
        for (int y = 1; y <= getHeight(); y++) {
            for (int x = 1; x <= getWidth(); x++) {
                if (get(x, y) == null)
                    blocks.get(y).put(x, new BlockNormal(new Coordinate(x,y)));
            }
        }
        rules.calculate();
    }

    void setRules(Rules rules) {
        this.rules = rules;
    }

    public int getWidth() {
        //noinspection OptionalGetWithoutIsPresent
        return blocks.values().stream().findFirst().get().size();
    }

    public int getHeight() {
        return blocks.size();
    }

    public Block get(int x, int y) {
        return Optional.ofNullable(blocks.get(y))
                .map(row -> row.get(x)).orElse(null);
    }

    public Block get(Coordinate coordinate) {
        return get(coordinate.x(), coordinate.y());
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public Collection<Map<Integer, Block>> getColumns() {
        return blocks.values();
    }
}
