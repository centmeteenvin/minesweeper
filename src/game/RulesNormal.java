package game;

import java.util.Map;

public class RulesNormal extends Rules{

    @Override
    public <T> void calculate() {
        for (Map<T, Block<T>> column: board.getColumns())
        //TODO
    }

    public void calculateBlock(Block<Integer> block) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0)
                    continue;
                Block<?> newBlock = board.relativeTo(block, x, y);
            }
        }
    }
}
