package doolhof.game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Remon
 */
public class GUI {
    private Game game;
    
    public GUI(Game game){
        this.game = game;
    }
    
    public void createFrame(){
        JFrame frame = new JFrame();
        frame.setTitle("Doolhof Game");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        addGamePanel(frame);
        frame.setVisible(true);
    }
    
    public void addGamePanel(JFrame frame){
        JPanel gamepanel = new JPanel();
        int cellsize = game.getField().getCellSize() + 1;
        int rows = game.getField().getRows();
        int columns = game.getField().getColumns();
        game.setPreferredSize(new Dimension(rows * cellsize, columns * cellsize));
        gamepanel.add(game);
        frame.add(gamepanel);
    }
}
