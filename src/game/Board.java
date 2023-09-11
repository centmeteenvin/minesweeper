package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import game.Block;

public class Board {
    protected final Map<Integer, Map<Integer, Block>> blocks = new HashMap<>();
    protected Rules rules;

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
    void setRules(Rules rules) {
        this.rules = rules;
    }
    //TODO

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

    public Collection<Map<Integer, Block>> getColumns() {
        return blocks.values();
    }
}
