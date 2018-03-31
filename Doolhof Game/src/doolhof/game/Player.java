package doolhof.game;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class Player{
    private int posX;
    private int posY;
    private Key key;
    
    public Player(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
    }
    
    public Key getKey(){
        return key;
    }
    
    public void setKey(Key key){
        this.key = key;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public void move(int x, int y)
    {
        posX += x;
        posY += y;
    }
    
    
   
}
    
    

