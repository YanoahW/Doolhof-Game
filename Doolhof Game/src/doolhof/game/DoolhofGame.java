package doolhof.game;

import java.io.IOException;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class DoolhofGame {
    public static void main (String[] args) throws IOException
    {
        System.out.println(100 - 030);
        Game game = new Game();
        Field field = new Field(10,10);
        field.setUpField("src/doolhof/game/data/standardField.txt");
        game.setField(field);
    }
    
}
