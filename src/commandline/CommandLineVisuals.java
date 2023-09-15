package commandline;

import game.Block;
import game.BlockBomb;
import game.BlockNormal;
import game.Visuals;

public class CommandLineVisuals extends Visuals {
    @Override
    public void draw() {
        int height = board.getHeight();
        int width = board.getHeight();
        StringBuilder out1 = new StringBuilder();
        StringBuilder out = new StringBuilder();
        for (int row = 1; row <= height; row++) {
            out1 = new StringBuilder("+");
            StringBuilder out2 = new StringBuilder("|");
            for (int column = 1; column <= width; column++) {
                out1.append(" --- +");
                Block block = board.get(column,row);
                char sign = '!';
                if (block == null)
                    sign = '#';
                else if (block.isFlagged()) {
                    sign = 'F';
                } else if (!block.isRevealed()) {
                    sign = '#';
                } else if (block instanceof BlockBomb) {
                    sign = '*';
                } else if (block instanceof BlockNormal normalBlock) {
                    if (normalBlock.getNumberOfBombs() == 0)
                        sign = ' ';
                    else sign = (char) (normalBlock.getNumberOfBombs() + '0');
                }
                out2.append("  ").append(sign).append("  |");
            }
            out.append(out1).append("\n").append(out2).append('\n');
        }
        out.append(out1);
        System.out.println(out);
    }
}
