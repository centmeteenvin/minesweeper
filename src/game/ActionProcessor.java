package game;

public class ActionProcessor {
    private final Board board;
    private Game game;
    private final int numberOfNormalBlocks;

    public ActionProcessor(Board board) {
        this.board = board;
        numberOfNormalBlocks = board.getHeight() * board.getWidth() - board.getNumberOfBombs();
    }

    public void process(UserAction userAction) {
        switch (userAction.action()) {
            case CLICK -> clickAction(userAction.coordinate());
            case FLAG -> flagAction(userAction.coordinate());
        }
    }

    public void clickAction(Coordinate coordinate) {
        Block block = board.get(coordinate);
        block.setRevealed(true);
        if (block instanceof BlockBomb bombBlock) {
            game.setGameState(GameState.LOST);
        }
        game.increment(1);
        if (numberOfNormalBlocks == game.numberOfRevealedNormalBlocks)
            game.setGameState(GameState.WON);
        if (block instanceof BlockNormal normalBlock && normalBlock.getNumberOfBombs() == 0) {
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if (x == 0 && y == 0)
                        continue;
                    Block newBlock = board.relativeTo(block,x,y);
                    if (newBlock != null && !newBlock.isRevealed()) {
                        clickAction(newBlock.getCoordinate());
                    }
                }
            }
        }
    }

    public void flagAction(Coordinate coordinate) {
        Block block = board.get(coordinate);
        block.setFlagged(!block.isFlagged());
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
