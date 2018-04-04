package doolhof.game;

/**
 * Class that generates a Barricade
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class Barricade extends Item {
    private int lock;
    
    public Barricade(int lock){
        this.lock = lock;
    }
    
    public int getLock(){
        return this.lock;
    }
    
    public void setLock(int lock){
        this.lock = lock;
    }
    
    public boolean checkKey(Key key){
        return this.lock == key.getPincode();
    }
    
}
