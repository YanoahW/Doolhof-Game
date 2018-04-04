package doolhof.game;

import java.io.IOException;

/**
 * Main method that executes all the necessary things
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class DoolhofGame {
    public static void main (String[] args) throws IOException {
        Game game = new Game();
        Field field = new Field(10,10,90);
        field.setUpField("src/doolhof/game/data/standardField.txt");
        game.setField(field);
        Player player = field.getPlayer();
        player.setField(game.getField());
        GUI gui = new GUI(game);
    }
}
