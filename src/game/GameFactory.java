package game;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GameFactory {
    public static Game create(User user, Visuals visuals) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/resources/configuration.properties"));

        Board board = new Board(Integer.parseInt(properties.getProperty("size.width")),
                Integer.parseInt(properties.getProperty("size.height")),
                Integer.parseInt(properties.getProperty("bombs")));
        Rules rules = new RulesNormal();
        ActionProcessor actionProcessor = new ActionProcessor(board);
        Game game = new Game(board, rules, visuals, user, actionProcessor);

        user.setGame(game);
        board.setRules(rules);
        rules.setBoard(board);
        actionProcessor.setGame(game);
        visuals.setGame(game);
        visuals.setBoard(board);
        return game;
    }
}
