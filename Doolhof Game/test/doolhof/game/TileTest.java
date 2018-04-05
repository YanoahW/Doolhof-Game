package doolhof.game;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test class to test the methods of Tile
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class TileTest {
    private Tile tile;
    private Barricade barricade;
    private Key key;
    private Wall wall;
    private Finish finish;
    
    /**
     * Method to set up all the initial values of the attributes
     */
    @Before
    public void setUp(){
        barricade = new Barricade(300);
        key = new Key(300);
        wall = new Wall();
        finish = new Finish();
    }

    /**
     * Method to test the isBarricade method, with a false and a true result
     */
    @Test
    public void testIsBarricade() {
        tile = new Tile(barricade);
        boolean expected = true;
        boolean result = tile.isBarricade();
        assertEquals(expected, result);
        tile.setItem(key);
        result = tile.isBarricade();
        expected = false;
        assertEquals(result, expected);
    }

    /**
     * Method to test the isKey method, with a false and a true result
     */
    @Test
    public void testIsKey() {
        tile = new Tile(key);
        boolean expected = true;
        boolean result = tile.isKey();
        assertEquals(expected, result);
        tile.setItem(barricade);
        result = tile.isKey();
        expected = false;
        assertEquals(result, expected);
    }
    
    /**
     * Method to test the isWall method, with a false and a true result
     */
    @Test
    public void testIsWall() {
        tile = new Tile(wall);
        boolean expected = true;
        boolean result = tile.isWall();
        assertEquals(expected, result);
        tile.setItem(finish);
        result = tile.isWall();
        expected = false;
        assertEquals(result, expected);
    }
    
    /**
     * Method to test the isFinish method, with a false and a true result
     */
    @Test
    public void testIsFinish() {
        tile = new Tile(finish);
        boolean expected = true;
        boolean result = tile.isFinish();
        assertEquals(expected, result);
        tile.setItem(barricade);
        result = tile.isFinish();
        expected = false;
        assertEquals(result, expected);
    }
}
