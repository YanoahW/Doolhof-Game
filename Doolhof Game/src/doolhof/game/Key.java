package doolhof.game;

/**
 * Class that generates a Key with a specific pincode, extends Item
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class Key extends Item {
    private int pincode;
    
    /**
     * Constructs a key object with a given pincode
     * @param pincode Pincode that has to be set on the key
     */
    public Key(int pincode){
        this.pincode = pincode;
    }
    
    /**
     * Gets the current pincode on the key
     * @return Returns an int, that contains the value of the pincode
     */
    public int getPincode(){
        return this.pincode;
    }
    
    /**
     * Sets the pincode to a given value
     * @param pincode Pincode that has to be set on the key
     */
    public void setPincode(int pincode){
        this.pincode = pincode;
    }
}
