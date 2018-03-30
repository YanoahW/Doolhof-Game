package doolhof.game;

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
        if (item == null) {
            return true;
        } else {
            return false;
        }
    }
    public Item getItem(){
        return item;
    }
    
    public void setItem(Item item) 
    {
        this.item = item;
    }    
}
