package doolhof.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
                    try{
                    paintWall(g, i, j, size);
                    } catch(IOException e){
                        System.out.println("File not found");
                    }
                }
                
                else if(tiles[i][j].getItem() instanceof Key){
                    Key key = (Key) tiles[i][j].getItem();
                    try{
                    paintKey(g, key, i, j, size);
                    } catch(IOException e){
                        System.out.println("File not found");
                    }
                }
                
                else if(tiles[i][j].getItem() instanceof Barricade){
                    Barricade barricade = (Barricade) tiles[i][j].getItem();
                    try{
                    paintBarricade(g, barricade, i, j, size);
                    } catch(IOException e){
                        System.out.println("File not found");
                    }
                }
                
                else if(tiles[i][j].getItem() instanceof Finish){
                    paintFinish(g, i, j, size);
                }
                
                else{
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(j * size, i * size, size, size);
                }
                
            g.setColor(Color.BLACK);
            g.drawRect(j * size, i * size, size, size);
            }
        }
        
        try{
        paintPlayer(g, field.getPlayer(), field.getPlayer().getPosX(), field.getPlayer().getPosY(), size);
        } catch(IOException e){
            System.out.println("File not found");
        }
        
    }
    
    public void paintWall(Graphics g, int x, int y, int size) throws IOException{
        Image image;
        image = ImageIO.read(new File("src/doolhof/game/data/Wall.png"));
        g.drawImage(image, (y * size),(x * size), this);
    }
    
    public void paintKey(Graphics g, Key key, int x, int y, int size) throws IOException{
        Image image;
        String pincode = "src/doolhof/game/data/K" + Integer.toString(key.getPincode()) + ".png";
        image = ImageIO.read(new File(pincode));
        g.drawImage(image, (y * size),(x * size), this);
    }
    
    public void paintBarricade(Graphics g, Barricade barricade, int x, int y, int size) throws IOException{
        Image image;
        String lock = "src/doolhof/game/data/B" + Integer.toString(barricade.getLock()) + ".png";
        image = ImageIO.read(new File(lock));
        g.drawImage(image, (y * size),(x * size), this);
    }
    
    public void paintPlayer(Graphics g, Player player, int x, int y, int size) throws IOException{
        Image image;
        image = ImageIO.read(new File("src/doolhof/game/data/Player.png"));
        g.drawImage(image, (y * size),(x * size), this);
        g.setColor(Color.BLACK);
        g.drawRect(field.getPlayer().getPosX() * size, field.getPlayer().getPosY() * size, size, size);
    }
    
    public void paintFinish(Graphics g, int x, int y, int size){
        g.setColor(Color.GREEN);
        g.fillRect(y * size, x * size, size, size);
    }
    
    @Override
    public void paintComponent(Graphics g){
        paintField(g);
    }
}
