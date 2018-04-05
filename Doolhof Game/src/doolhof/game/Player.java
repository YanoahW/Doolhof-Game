package doolhof.game;

/**
 * Class that generates a Player, handles the moves the player makes and checks whether the player has a key or not
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0 
 */
public class Player{
    private int posX;
    private int posY;
    private Field field;
    private Key key;
    
    /**
     * constructs a player with a start position on the field
     * @param posX The x position where the player starts, which is the horizontal axis
     * @param posY The y position where the player starts, which is the vertical axis
     * The initial field of the player is set to a null object
     */
    public Player(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        this.field = null;
        this.key = null;
    }
    
    /**
     * Gets the current key of the player
     * @return Returns a key object
     */
    public Key getKey(){
        return key;
    }
    
    /**
     * Gets the current x position of the player
     * @return returns the current x position
     */
    public int getPosX(){
        return posX;
    }
    
    /**
     * Gets the current y position of the player
     * @return returns the current y position of the player
     */
    public int getPosY(){
        return posY;
    }
    
    /**
     * Sets the field on which the player has to move
     * @param field The field where the player has to move
     */
    public void setField(Field field){
        this.field = field;
    }
    
    /**
     * Method that picks up a key
     * @param key an instance of the class Key
     */
    public void pickUpKey(Key key){
        this.key = key;
    }
    
    /**
     * Method that checks whether the player has a key or not
     * @return Returns a boolean, true when the player has a key and false when the player does not have a key
     */
    public boolean hasKey(){
        return !(key == null);
    }
    
    /**
     * method that makes it able for the player to make moves
     * @param x The x position that has to be changed after a key is pressed
     * @param y The y position that has to be changed after a key is pressed
     */
    public void move(int x, int y){
        if(!field.checkFinish((posX), (posY))){ //player is able to move when the finish isnt reached yet
            if(!field.checkCollision((posX + x), (posY + y))){ //player is able to move when there isn't any object blockint it's way
            posX += x;
            posY += y;
            }
        } 
        field.handleCollision((posX), (posY)); //Let the player picks up keys and destroy barricades with the handleCollision method from field
    }
}