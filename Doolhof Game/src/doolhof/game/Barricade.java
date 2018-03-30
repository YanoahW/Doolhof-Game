package doolhof.game;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
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
        if(this.lock == key.getPincode()){
            return true;
        }
        else{
            return false;
        }
    }
    
}
