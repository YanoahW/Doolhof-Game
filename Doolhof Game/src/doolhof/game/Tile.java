package doolhof.game;

/**
 * Class that generates a Tile using one of the items and also checks what item is on a tile
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
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
