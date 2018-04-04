package doolhof.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Remon
 */
public class GUI extends JFrame{
    private Game game;
    private final int FRAME_WIDTH = 1050;
    private final int FRAME_HEIGHT = 1080;
    
    public GUI(Game game){
        this.game = game;
        super.setTitle("Doolhof Game");
        super.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        this.createPanels();
        KeyListener keylistener = new MoveListener();
        addKeyListener(keylistener);
        setVisible(true);
    }
    
    public void createPanels(){
        JPanel gamePanel = createGamePanel();
        JPanel instructionPanel = createInstructionPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(instructionPanel);
        mainPanel.add(gamePanel);
        this.add(mainPanel);
    }
    
    public JPanel createGamePanel(){
        JPanel panel = new JPanel();
        int cellsize = game.getField().getCellSize() + 1;
        int rows = game.getField().getRows();
        int columns = game.getField().getColumns();
        game.setPreferredSize(new Dimension(rows * cellsize, columns * cellsize));
        panel.add(game);
        return panel;
    }
    
    public JPanel createInstructionPanel() {
        JPanel panel = new JPanel();
        JLabel instruction = new JLabel("Use the arrow keys to move and type 'r' if you want to reset this level.");
        JLabel motivation = new JLabel("GOOD LUCK!");
        Font font = new Font("Verdana", Font.BOLD | Font.ITALIC, 23);
        instruction.setFont(font);
        motivation.setFont(font);
        panel.add(instruction);
        panel.add(motivation, BorderLayout.SOUTH);
        return panel;
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
            } else if(e.getKeyCode() == KeyEvent.VK_R){
                try {
                    game.resetGame("src/doolhof/game/data/standardField.txt");
                } catch (IOException ex) {
                   System.out.print("File not found");
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
