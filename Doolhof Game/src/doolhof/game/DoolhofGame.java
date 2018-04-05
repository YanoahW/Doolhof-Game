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
    /**
     * Main mathod to run the game
     * @param args
     * @throws IOException when the level file is not found, an exception will be thrown
     */
    public static void main (String[] args) throws IOException {
        Game game = new Game(); //Setting up a new game
        Field field = new Field(10,10,90); //Setting up a new field
        field.setUpField("src/doolhof/game/data/standardField.txt"); //Initializing the field with a given txt file
        game.setField(field); //Put the field into the game
        Player player = field.getPlayer(); //Setting up a new Player
        player.setField(game.getField()); //Giving the created field to the player 
        GUI gui = new GUI(game); //Set up the Graphical User Interface, with the created game
    }
}
