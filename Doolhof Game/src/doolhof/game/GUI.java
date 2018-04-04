package doolhof.game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Remon
 */
public class GUI extends JFrame{
    private Game game;
    private JPanel gamePanel;
    private JPanel buttonPanel;
    private KeyListener keylistener;
    
    public GUI(Game game){
        this.game = game;
        super.setTitle("Doolhof Game");
        super.setSize(1200,1000);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        this.gamePanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.keylistener = new MoveListener();
        this.addKeyListener(keylistener);
        this.setUpGUI();
        this.addResetButton();
    }
    
    public void setUpGUI(){
        int cellsize = game.getField().getCellSize() + 1;
        int rows = game.getField().getRows();
        int columns = game.getField().getColumns();
        game.setPreferredSize(new Dimension(rows * cellsize, columns * cellsize));
        gamePanel.add(game);
        super.add(gamePanel);
        super.setVisible(true);
    }
    
    public void addResetButton(){
        JButton reset = new JButton("Reset Level");
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    game.resetGame("src/doolhof/game/data/standardField.txt");
                } catch (IOException ex) {
                    System.out.println("File not found");
                }
            }
        });
        buttonPanel.add(reset);
        gamePanel.add(buttonPanel);
    }
    
    public void showFinishMessage(){
        JOptionPane.showMessageDialog(null, "LEVEL COMPLETED!");
    }
    
    public void showBarricadeMessage(){
        JOptionPane.showMessageDialog(null, "You don't have the right key, keep looking!");
    } 
    
    class MoveListener implements KeyListener{
        @Override
        public void keyReleased(KeyEvent e) {
            int playerPosX = game.getField().getPlayer().getPosX();
            int playerPosY = game.getField().getPlayer().getPosY();
            int fieldRows = game.getField().getRows() - 1;
            int fieldColumns = game.getField().getColumns() - 1;
            if(e.getKeyCode()== KeyEvent.VK_RIGHT && playerPosX < fieldColumns){
                game.getField().getPlayer().move(1,0);
                game.updateField();
                if(game.getField().finishReached()){
                    showFinishMessage();
                } 
                if(game.getField().checkBarricade(playerPosX + 1, playerPosY)){
                    showBarricadeMessage();
                }
            } else if(e.getKeyCode()== KeyEvent.VK_LEFT && playerPosX > 0){
                game.getField().getPlayer().move(-1,0);
                game.updateField();
                if(game.getField().finishReached()){
                    showFinishMessage();
                }
                if(game.getField().checkBarricade(playerPosX - 1, playerPosY)){
                    showBarricadeMessage();
                }
            } else if(e.getKeyCode()== KeyEvent.VK_DOWN && playerPosY < fieldRows){
                game.getField().getPlayer().move(0,1);
                game.updateField();
                if(game.getField().finishReached()){
                    showFinishMessage();
                }
                if(game.getField().checkBarricade(playerPosX, playerPosY + 1)){
                    showBarricadeMessage();
                }
            } else if(e.getKeyCode()== KeyEvent.VK_UP  && playerPosY > 0){
                game.getField().getPlayer().move(0,-1);
                game.updateField();
                if(game.getField().finishReached()){
                    showFinishMessage();
                }
                if(game.getField().checkBarricade(playerPosX, playerPosY - 1)){
                    showBarricadeMessage();
                }
            }
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }  
        
    }
    
}
