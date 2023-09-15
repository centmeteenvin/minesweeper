import commandline.CommandLineUser;
import commandline.CommandLineVisuals;
import game.Game;
import game.GameFactory;
import java2d.Java2DVisuals;

import java.io.IOException;

public class Minesweeper {
    public static void main(String[] args) throws IOException {
        Game minesweeper = GameFactory.create(new CommandLineUser(), new Java2DVisuals());
        minesweeper.start();
        System.out.println("hello world!");
    }
}
