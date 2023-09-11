package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import game.Block;

public abstract class Board<T> {
    protected final Map<T, Map<T, Block<T>>> blocks = new HashMap<>();
    protected Rules rules;

    public abstract Block<T> relativeTo(Block<T> block, int deltaX, int deltaY);

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

    public Block<T> get(T x, T y) {
        return Optional.ofNullable(blocks.get(y))
                .map(row -> row.get(x)).orElse(null);
    }

    public Map<T, Block<T>> getColumns() {
        return blocks.values();
    }
}
