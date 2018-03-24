package doolhof.game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yanoah Wiersma & Remon Turk
 * Klas: 3.6
 */
public class Game {
    private Field field;
    
    public Game(Field field)
    {
        this.field = field;
    }
    
    public Field getField()
    {
        return field;
    }
    
    public void setField(Field field)
    {
        this.field = field;
    }
    
    

}
