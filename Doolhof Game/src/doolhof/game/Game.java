package doolhof.game;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class Game {
    private Field field;
    private boolean gameOver;
    
    public Game(Field field)
    {
        this.field = field;
        gameOver = false;
    }
    
    public Field getField()
    {
        return field;
    }
    
    public void setField(Field field)
    {
        this.field = field;
    }
    
    public void createField(Tile[][] gridGame)
    {
        
    }
    

}
