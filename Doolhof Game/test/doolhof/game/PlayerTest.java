package doolhof.game;

import java.io.IOException;
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
public class PlayerTest {
    private Player player;
    private int pincode;
    private Key key;
    private Field field;
    
     /**
     * Method to set up all the initial values of the attributes
     */
    @Before
    public void setUp() throws IOException {
        pincode = 300;
        key = new Key(pincode);
        player = new Player(8,7);
        field = new Field(10,10,90);
        field.setUpField("src/doolhof/game/data/standardField.txt");
        player.setField(field);
    }

    @Test
    public void testPickUpKey() {
        player.pickUpKey(key);
        Key result = player.getKey();
        assertEquals(key, result);
    }

    @Test
    public void testHasKey() {
        Key expected = null;
        Key result = player.getKey();
        assertEquals(expected, result);
        player.pickUpKey(key);
        result = player.getKey();
        assertEquals(key, result);
    }

    @Test
    public void testMoveRight() {
        player.move(1, 0);
        int resultX = player.getPosX();
        int resultY = player.getPosY();
        int expectedX = 9;
        int expectedY = 7;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
    }
    
    @Test
    public void testMoveLeft() {
        player.move(-1, 0);
        int resultX = player.getPosX();
        int resultY = player.getPosY();
        int expectedX = 7;
        int expectedY = 7;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
    }
    
    @Test
    public void testMoveUp() {
        player.move(0, -1);
        int resultX = player.getPosX();
        int resultY = player.getPosY();
        int expectedX = 8;
        int expectedY = 6;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
    }
    
    @Test
    public void testMoveDown() {
        player.move(0, 1);
        int resultX = player.getPosX();
        int resultY = player.getPosY();
        int expectedX = 8;
        int expectedY = 8;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
    }
    
    @Test
    public void testMoveBarricade(){
        player = new Player(5,5);
        player.setField(field);
        field.setPlayer(player);
        player.move(0, 1);
        int resultX = player.getPosX();
        int resultY = player.getPosY();
        int expectedX = 5;
        int expectedY = 5;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
        player.pickUpKey(key);
        player.move(0, 1);
        resultX = player.getPosX();
        resultY = player.getPosY();
        expectedX = 5;
        expectedY = 6;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
    }
    
    @Test
    public void testMoveKey(){
        player = new Player(4,0);
        player.setField(field);
        field.setPlayer(player);
        player.move(0, 1);
        int resultX = player.getPosX();
        int resultY = player.getPosY();
        int expectedX = 4;
        int expectedY = 1;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
    }
    
    @Test
    public void testMoveFinish(){
        player = new Player(9,8);
        player.setField(field);
        field.setPlayer(player);
        player.move(0, 1);
        int resultX = player.getPosX();
        int resultY = player.getPosY();
        int expectedX = 9;
        int expectedY = 9;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
    }
    
    @Test
    public void testMoveWall(){
        player = new Player(0,0);
        player.setField(field);
        field.setPlayer(player);
        player.move(1, 0);
        int resultX = player.getPosX();
        int resultY = player.getPosY();
        int expectedX = 0;
        int expectedY = 0;
        assertEquals(resultX, expectedX);
        assertEquals(resultY, expectedY);
    }
}
