package doolhof.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
        frame.add(createGamePanel());
        frame.setVisible(true);
    }
    
    public JPanel createGamePanel(){
        JPanel gamepanel = new JPanel();
        game.setPreferredSize(new Dimension(game.getField().getRows() * game.getField().getCellSize() + 1, game.getField().getColumns() * game.getField().getCellSize() + 1));
        gamepanel.add(game);
        return gamepanel;
    }
}
