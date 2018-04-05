package doolhof.game;

/**
 * Class that generates a Barricade, extends Item
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class Barricade extends Item {
    private int lock;
    
    /**
     * Constructs a barricade object with a given lock
     * @param lock The lock that is on the barricade
     */
    public Barricade(int lock){
        this.lock = lock;
    }
    
    /**
     * Gets the lock of the barricade
     * @return Returns the lock value
     */
    public int getLock(){
        return this.lock;
    }
    
    /**
     * Sets the lock of the Barricade
     * @param lock Given lock which has to be on the barricade
     */
    public void setLock(int lock){
        this.lock = lock;
    }
    
    /**
     * Method that checks if a key fits on this barricade or not
     * @param key The key which has to be compared with the barricade
     * @return Returns a boolean true, when the key fits and false when it doesn't
     */
    public boolean checkKey(Key key){
        return this.lock == key.getPincode();
    }
    
}
