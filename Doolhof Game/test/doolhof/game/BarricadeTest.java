package doolhof.game;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test class to test the method checkKey with a right key and a wrong key
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class BarricadeTest {
    private int lock;
    private Barricade barricade;
    private int pincode1;
    private int pincode2;
    private Key key;
    
     /**
     * Method to set up all the initial values of the attributes
     */
    @Before
    public void setUp(){
        lock = 300;
        barricade = new Barricade(lock);
        pincode1 = 300;
        pincode2 = 200;
    }

    /**
     * Method to test the right key on a barricade and the wrong key aswell
     */
    @Test
    public void testCheckKey() {
        key = new Key(pincode1);
        boolean expected = true;
        boolean result = barricade.checkKey(key);
        assertEquals(expected, result);
        key = new Key(pincode2);
        expected = false;
        result = barricade.checkKey(key);
        assertEquals(expected, result);
    }
}
