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
    
    public Tile(Item item){
        this.item = item;
    }
    
    public Item getItem(){
        return item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    } 
    
    public boolean isBarricade(){
        if (item instanceof Barricade){
            return true;
        }
        return false;
    }
    
    public boolean isKey(){
        if (item instanceof Key){
            return true;
        }
        return false;
    }
    
    public boolean isWall(){
        if (item instanceof Wall){
            return true;
        } 
        return false;
    }
    
    public boolean isFinish(){
        if (item instanceof Finish){
            return true;
        } 
        return false;
    }
}
