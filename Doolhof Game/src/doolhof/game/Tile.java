package doolhof.game;

import java.util.ArrayList;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class Tile {
    private Item item;
    
    public Tile(Item item)
    {
        this.item = item;
    }
    
    public boolean isEmpty()
    {
        boolean result;
        
        if (item == null) {
            result = true;
        } else {
            result = false;
        }
        
        return result;
    }
    
    
}
