package doolhof.game;

/**
 * Class that generates a Key with a specific pincode, extends item
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class Key extends Item {
    private int pincode;
    
    public Key(int pincode){
        this.pincode = pincode;
    }
    
    public int getPincode(){
        return this.pincode;
    }
    
    public void setPincode(int pincode){
        this.pincode = pincode;
    }
    
}
