package racinggame;

import racinggame.view.Game;
import racinggame.view.RacingGame;

public class Application {
    public static void main(String[] args) {
        Game game = new RacingGame();
        game.start();
    }
}
