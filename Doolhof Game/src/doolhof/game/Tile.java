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
    
    /**
     * Constructs a tile object with a given item
     * @param item The item that has to be placed on a tile
     */
    public Tile(Item item){
        this.item = item;
    }
    
    /**
     * Gets the current item placed on the tile
     * @return Returns an object from the corresponding subclass
     */
    public Item getItem(){
        return item;
    }
    
    /**
     * Sets an item onto a tile
     * @param item The item that has to be placed on a tile
     */
    public void setItem(Item item) {
        this.item = item;
    } 
    
    /**
     * Checks if there is a Barricade item located on a tile
     * @return Returns a boolean true when there is a barricade, else false is returned
     */
    public boolean isBarricade(){
        return item instanceof Barricade;
    }
    
    /**
     * Checks if there is a Key item located on a tile
     * @return Returns a boolean true when there is a key, else false is returned
     */
    public boolean isKey(){
        return item instanceof Key;
    }
    
    /**
     * Checks if there is a Wall item located on a tile
     * @return Returns a boolean true when there is a wall, else false is returned
     */
    public boolean isWall(){
        return item instanceof Wall;
    }
    
    /**
     * Checks if there is a Finish item located on a tile
     * @return Returns a boolean true when there is a finish, else false is returned
     */
    public boolean isFinish(){
        return item instanceof Finish;
    }
}
