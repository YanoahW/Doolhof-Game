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
    private final Tile[][] gridGame;
    private final int rows;
    private final int columns;
    
    public Field(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.gridGame = new Tile[rows][columns];
    }
    
    public void Fill2DArray()
    {
        
    }
    
    
    
    
}
