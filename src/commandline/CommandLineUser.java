package commandline;

import game.Action;
import game.Coordinate;
import game.User;
import game.UserAction;

import java.util.Scanner;

public class CommandLineUser extends User {
    private final Scanner input = new Scanner(System.in);

    @Override
    public UserAction getUserAction(boolean onlyCoordinate) {
        System.out.print("Coordinate? (x,y): ");
        String[] stringCoordinate = input.nextLine().split(",");
        Coordinate coordinate = new Coordinate(Integer.parseInt(stringCoordinate[0]), Integer.parseInt(stringCoordinate[1]));
        Action action = Action.CLICK;
        if (!onlyCoordinate) {
            action = getAction();
        }
        return new UserAction(action, coordinate);
    }

    private Action getAction() {
        Action action = Action.CLICK;
        boolean validInput = true;
        do {
            validInput = true;
            System.out.print("Action? CLICK/FLAG/MAYBE: ");
            String stringAction = input.nextLine();
            switch (stringAction) {
                case "CLICK" -> action = Action.CLICK;
                case "FLAG" -> action = Action.FLAG;
                case "MAYBE" -> action = Action.MAYBE;
                default -> {
                    validInput = false;
                    System.out.println("ER ZIJN MAAAR " + Action.values().length + " MOGELIJKHEDEN ATM! BEN JE DOM OF DOE JE DOM!!!!");
                }
            }
        } while (!validInput);
        return action;
    }
}

