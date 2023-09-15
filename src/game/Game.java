package game;

import java.util.List;

public class Game {
    final Board board;
    final Rules rules;
    final Visuals visuals;
    final User user;
    final ActionProcessor actionProcessor;
    GameState gameState = GameState.IDLE;
    UserAction userAction;
    int numberOfRevealedNormalBlocks = 0;

    Game(Board board, Rules rules, Visuals visuals, User user, ActionProcessor actionProcessor) {
        this.board = board;
        this.rules = rules;
        this.visuals = visuals;
        this.user = user;
        this.actionProcessor = actionProcessor;
    }

    public void start() {
        gameState = GameState.PLAYING;
        visuals.draw();
        user.requestAction(true);
        board.placeBombs(List.of(userAction.coordinate()));
        board.placeBlocks();
        actionProcessor.process(userAction);
        visuals.draw();
        gameLoop();
    }

    public void gameLoop() {
        while (gameState == GameState.PLAYING) {
            user.requestAction(false);
            actionProcessor.process(userAction);
            visuals.draw();
        }
    }

    public void receiveAction(UserAction userAction) throws OutOfBoundsException {
        //filters
        if (userAction.coordinate().x() < 1 || userAction.coordinate().x() > board.getWidth() ||
                userAction.coordinate().y() < 1 || userAction.coordinate().y() > board.getHeight()) {
            throw new OutOfBoundsException(userAction.coordinate(), board.getWidth(), board.getHeight());
        }
        this.userAction = userAction;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void increment(int increaseNumber) {
        numberOfRevealedNormalBlocks += increaseNumber;
    }
}
