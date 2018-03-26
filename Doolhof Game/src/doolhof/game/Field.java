package doolhof.game;

import java.util.ArrayList;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class Field {
    private Player player;
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private int row;
    private int column;
    private int[][] gridGame = new int[row][column];
    
    public Field(ArrayList<Tile> tiles)
    {
        this.tiles =  tiles;
    }
    
}
