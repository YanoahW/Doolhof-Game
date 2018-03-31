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
    private Field field;
    private Key key;
    
    public Player(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        this.field = null;
    }
    
    public Key getKey(){
        return key;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public void setField(Field field){
        this.field = field;
    }
    
    public void pickUpKey(Key key){
        this.key = key;
    }
    
    public void move(int x, int y){
        if(!field.checkFinish((posX), (posY))){
            if(!field.checkCollision((posX + x), (posY + y))){
            posX += x;
            posY += y;
            }
        }
    }
}
    
    

