package doolhof.game;

import java.io.IOException;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum: 27
 * Versie:
 */
public class DoolhofGame {
    public static void main (String[] args) throws IOException
    {
        Game game = new Game();
        Field field = new Field(10,10,90);
        field.setUpField("src/doolhof/game/data/standardField.txt");
        game.setField(field);
        Player player = field.getPlayer();
        player.setField(game.getField());
        GUI gui = new GUI(game);
        gui.addGamePanel();
    }
    
}
