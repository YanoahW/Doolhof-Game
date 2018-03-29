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
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.gridGame[i][j] = new Tile(null);
            }
        }
    }
    
    public void setPlayer(Player player) 
    {
        this.player = player;
    }
    
    public void setFieldItem(int row, int column, Item item)
    {
        this.gridGame[row][column].setItem(item);
    }
    
    
    
    
}
