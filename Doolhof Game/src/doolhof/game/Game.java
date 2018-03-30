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
        try{
            for(int x = 0; x < rows; x++){
                for(int y = 0; y < columns; y++){
                    if(tiles[x][y].getItem() instanceof Wall){
                        paintWall(g, x, y, size);
                    } else if(tiles[x][y].getItem() instanceof Key){
                        paintKey(g, ((Key) tiles[x][y].getItem()), x, y, size);
                    } else if(tiles[x][y].getItem() instanceof Barricade){
                        paintBarricade(g, ((Barricade) tiles[x][y].getItem()), x, y, size);
                    } else if(tiles[x][y].getItem() instanceof Finish){
                        paintFinish(g, x, y, size);
                    } else{
                        paintEmpty(g, x, y, size);
                    }
                g.setColor(Color.BLACK);
                g.drawRect(y * size, x * size, size, size);
                }
            }
        paintPlayer(g, field.getPlayer(), field.getPlayer().getPosX(), field.getPlayer().getPosY(), size);
        } catch(IOException e){
            System.out.println("File not found");
        }
    }

    @Override
    public void paintComponent(Graphics g){
        paintField(g);
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
        g.drawImage(image, (x * size),(y * size), this);
        g.setColor(Color.BLACK);
        g.drawRect(field.getPlayer().getPosX() * size, field.getPlayer().getPosY() * size, size, size);
    }
    
    public void paintFinish(Graphics g, int x, int y, int size){
        g.setColor(Color.GREEN);
        g.fillRect(y * size, x * size, size, size);
    }
    
    public void paintEmpty(Graphics g, int x, int y, int size){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(y * size, x * size, size, size);
    }
}
