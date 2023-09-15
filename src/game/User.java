package game;

public abstract class User {
    protected Game game;
    public final void requestAction(boolean onlyCoordinate) {
        boolean isCorrectInput = false;
        while (!isCorrectInput) {
            try {
                game.receiveAction(getUserAction(onlyCoordinate));
                isCorrectInput = true;
            } catch (OutOfBoundsException e) {
                System.out.print("BITCH DENK NA! BORD IS MAAR " + e.maxX + " BREED EN " + e.maxY + " GROOT DOMOOR!\n");
            }
        }
    }

    protected abstract UserAction getUserAction(boolean onlyCoordinate);

    public void setGame(Game game) {
        this.game = game;
    }
}
