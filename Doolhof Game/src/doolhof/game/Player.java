package doolhof.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class Player implements KeyListener{
    private int posX;
    private int posY;
    
    public Player()
    {
        int posX = 0;
        int posY = 0;
    }
    
    public void move(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            posX--;
        }
        
        if(key == KeyEvent.VK_RIGHT)
        {
            posX++;
        }
        
        if(key == KeyEvent.VK_UP)
        {
            posY++;
        }
        
        if(key == KeyEvent.VK_DOWN)
        {
            posY++;
            
        
        
    }
    
    
}
