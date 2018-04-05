package doolhof.game;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test class to test the methods of Field
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class FieldTest {
    private Field field;
    private Barricade barricade;
    private Key key;
    private Finish finish;
    private Wall wall;
    private String filename;
    private Player player;
    
    /**
     * Method to set up all the initial values of the attributes
     */
    @Before
    public void setUp() {
        filename = "src/doolhof/game/data/standardField.txt";
        field = new Field(10,10,90);
        barricade = new Barricade(300);
        key = new Key(200);
        finish = new Finish();
        wall = new Wall();
        player = new Player(9,9);
        field.setPlayer(player);
    }
    
    /**
     * Method to test the setUpField method
     * @throws Exception when the file cannot be found, an Exception is thrown
     */
    @Test
    public void testSetUpField() throws Exception {
        field.setUpField(filename);
        boolean result = field.getGridGame()[0][1].isWall();
        boolean expected = true;
        assertEquals(result, expected);
        
        result = field.getGridGame()[0][7].isBarricade();
        barricade = (Barricade) field.getGridGame()[0][7].getItem();
        int value = barricade.getLock();
        assertEquals(value, 30);
        assertEquals(result, expected);
        
        result = field.getGridGame()[1][5].isKey();
        key = (Key) field.getGridGame()[1][5].getItem();
        value = key.getPincode();
        assertEquals(value, 300);
        assertEquals(result, expected);
        
        result = field.getGridGame()[9][9].isFinish();
        assertEquals(result, expected);
    }

    @Test
    public void testFinishReached() {
        field.getGridGame()[9][9].setItem(finish);
        boolean expected = true;
        boolean result = field.finishReached();
        assertEquals(expected, result);
        field.getGridGame()[9][9].setItem(null);
        field.getGridGame()[8][9].setItem(finish);
        expected = false;
        result = field.finishReached();
        assertEquals(expected, result);
    }  
}
