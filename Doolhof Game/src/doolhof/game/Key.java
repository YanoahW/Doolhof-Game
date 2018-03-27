package doolhof.game;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
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
