package doolhof.game;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Remon
 */
public class GUI extends JFrame{
    private Game game;
    
    public GUI(Game game){
        this.game = game;
        super.setTitle("Doolhof Game");
        super.setSize(1000,1200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        KeyListener keylistener = new MoveListener();
        super.addKeyListener(keylistener);
        super.setVisible(true);
    }
    
    public void addGamePanel(){
        JPanel gamepanel = new JPanel();
        int cellsize = game.getField().getCellSize() + 1;
        int rows = game.getField().getRows();
        int columns = game.getField().getColumns();
        game.setPreferredSize(new Dimension(rows * cellsize, columns * cellsize));
        gamepanel.add(game);
        add(gamepanel);
    }
    
    class MoveListener implements KeyListener{
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()== KeyEvent.VK_RIGHT && game.getField().getPlayer().getPosX() < game.getField().getColumns() - 1){
            game.getField().getPlayer().move(1,0);
            game.updateField();
           } else if(e.getKeyCode()== KeyEvent.VK_LEFT && game.getField().getPlayer().getPosX() > 0){
            game.getField().getPlayer().move(-1,0);
            game.updateField();
           } else if(e.getKeyCode()== KeyEvent.VK_DOWN && game.getField().getPlayer().getPosY() < game.getField().getRows() - 1){
            game.getField().getPlayer().move(0,1);
            game.updateField();
           } else if(e.getKeyCode()== KeyEvent.VK_UP  && game.getField().getPlayer().getPosY() > 0){
            game.getField().getPlayer().move(0,-1);
            game.updateField();
           }
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }  
    }
    
    public void showMessage(){
        JOptionPane.showMessageDialog(null, "A basic JOptionPane message dialog");
    }
}
