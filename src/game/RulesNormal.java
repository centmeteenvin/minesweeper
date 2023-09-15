package game;

import java.util.Map;

public class RulesNormal extends Rules{

    @Override
    public void calculate() {
        for (Map<Integer, Block> column: board.getColumns()) {
            for (Block block : column.values()) {
                if (block instanceof BlockNormal normalBlock)
                    calculateBlock(normalBlock);
            }
        }
    }

    public void calculateBlock(BlockNormal block) {
        int counter = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0)
                    continue;
                Block newBlock = board.relativeTo(block, x, y);
                if (newBlock instanceof BlockBomb)
                    counter++;
            }
        }
        block.setNumberOfBombs(counter);
    }
}
