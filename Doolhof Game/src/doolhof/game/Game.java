package doolhof.game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class Game extends JComponent {
    private Field field;
    private boolean gameOver;
    
    public Game()
    {
        this.field = null;
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
    
    public void paintField(Graphics g){
        final int size = field.getCellSize();
        final int rows = field.getRows();
        final int columns = field.getColumns();
        
        Tile[][] tiles = field.getGridGame();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(tiles[i][j].getItem() instanceof Wall){
                    paintWall(g, i, j, size);
                }
                else if(tiles[i][j].getItem() instanceof Key){
                    Item item = tiles[i][j].getItem();
                    Key key = (Key) item;
                    paintKey(g, key, i, j, size);
                }
                else if(tiles[i][j].getItem() instanceof Barricade){
                    g.setColor(Color.RED);
                    g.fillRect(j * size, i * size, size, size);
                }
                else if(tiles[i][j].getItem() instanceof Finish){
                    g.setColor(Color.GREEN);
                    g.fillRect(j * size, i * size, size, size);
                    
                }
                else{
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(j * size, i * size, size, size);
                }
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
            }
        }
    }
    
    public void paintWall(Graphics g, int x, int y, int size){
        g.setColor(Color.BLACK);
        g.fillRect(y * size, x * size, size, size);
    }
    
    public void paintKey(Graphics g, Key key, int x, int y, int size){
        if(key.getPincode() == 100){
            g.setColor(Color.ORANGE);
            g.fillRect(y * size, x * size, size, size);
            }
        else if(key.getPincode() == 200){
            g.setColor(Color.CYAN);
            g.fillRect(y * size, x * size, size, size);
        }
        else if(key.getPincode() == 300){
            g.setColor(Color.PINK);
            g.fillRect(y * size, x * size, size, size);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        paintField(g);
    }
}
