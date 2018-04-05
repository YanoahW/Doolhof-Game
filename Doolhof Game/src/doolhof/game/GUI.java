package doolhof.game;

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
 * Class that shows the actual game to the user
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class GUI extends JFrame{
    private Game game;
    private final int FRAME_WIDTH = 1050;
    private final int FRAME_HEIGHT = 1080;
    
    /**
     * Constructs a GUI object with a given game
     * @param game The game that has to be shown to the user
     */
    public GUI(Game game){
        this.game = game;
        super.setTitle("Doolhof Game");
        super.setSize(FRAME_WIDTH, FRAME_HEIGHT); //Setting the size of the frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Setting the default close operation
        super.setLocationRelativeTo(null); //Centering the frame to the users screen
        this.createPanels(); //Calling the createPanels method to make all the panels that are needed
        KeyListener keylistener = new MoveListener();
        addKeyListener(keylistener); //Adding a key listener, so that the user can interact with the game
        setVisible(true); //Making the frame visible
    }
    
    /**
     * Creating all the needed panels for the game
     */
    public void createPanels(){
        JPanel gamePanel = createGamePanel(); //Making the gamePanel, which holds the actual game
        JPanel instructionPanel = createInstructionPanel(); //Making a instruction panel, which has a label with the instructions
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //Setting a y-axis based layout
        mainPanel.add(instructionPanel);
        mainPanel.add(gamePanel);
        this.add(mainPanel); //Adding all the panels to the mainPanel, and adding the mainPanel to the frame
    }
    
    /**
     * Creating a gamePanel which holds the actual game and returning this panel
     * @return The gamePanel which holds the game is returned
     */
    public JPanel createGamePanel(){
        JPanel panel = new JPanel();
        int cellsize = game.getField().getCellSize() + 1;
        int rows = game.getField().getRows();
        int columns = game.getField().getColumns();
        game.setPreferredSize(new Dimension(rows * cellsize, columns * cellsize)); //Setting the preffered size of the game
        panel.add(game); //Adding the game component to the panel
        return panel;
    }
    
    /**
     * Creating a buttonPanel which holds the instructions for the game and returning this panel
     * @return The buttonPanel which holds the instructions is returned
     */
    public JPanel createInstructionPanel() {
        JPanel panel = new JPanel();
        JLabel instruction = new JLabel("Use the arrow keys to move and type 'r' if you want to reset this level.");
        JLabel motivation = new JLabel("GOOD LUCK!");
        Font font = new Font("Verdana", Font.BOLD | Font.ITALIC, 23); //Creating a font for the panels
        instruction.setFont(font);
        motivation.setFont(font); //Adding the fonts to the labels
        panel.add(instruction);
        panel.add(motivation); //Adding the labels to the panel
        return panel;
    }
    
    /**
     * Method that shows a message, when the finish is reached
     */
    public void showFinishMessage(){
        JOptionPane.showMessageDialog(null, "LEVEL COMPLETED!");
    }
    
    /**
     * Method that shows a message when the player doesn't have the right key
     */
    public void showBarricadeMessage(){
        JOptionPane.showMessageDialog(null, "You don't have the right key, keep looking!");
    } 

    /**
     * Inner class MoveListener which extends the KeyListener interface, it is needed for the user to interact
     */
    class MoveListener implements KeyListener{
        /**
         * Overriding the keyReleased method with our own implementation, which differs when a different key is being pressed
         * @param e Key that is pressed
         */
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
                    showFinishMessage(); //Check if the player has reached the finish after moving, if it is the case show a message
                } 
                if(game.getField().checkBarricade(playerPosX + 1, playerPosY)){
                    showBarricadeMessage(); //Check if the player collides with a barricade, and doesnt have the right key. When the case show a message
                }
            } else if(e.getKeyCode()== KeyEvent.VK_LEFT && playerPosX > 0){
                game.getField().getPlayer().move(-1,0);
                game.updateField();
                if(game.getField().finishReached()){
                    showFinishMessage(); //Check if the player has reached the finish after moving, if it is the case show a message
                } 
                if(game.getField().checkBarricade(playerPosX - 1, playerPosY)){
                    showBarricadeMessage(); //Check if the player collides with a barricade, and doesnt have the right key. When the case show a message
                }
            } else if(e.getKeyCode()== KeyEvent.VK_DOWN && playerPosY < fieldRows){
                game.getField().getPlayer().move(0,1);
                game.updateField();
                if(game.getField().finishReached()){
                    showFinishMessage(); //Check if the player has reached the finish after moving, if it is the case show a message
                }
                if(game.getField().checkBarricade(playerPosX, playerPosY + 1)){
                    showBarricadeMessage(); //Check if the player collides with a barricade, and doesnt have the right key. When the case show a message
                }
            } else if(e.getKeyCode()== KeyEvent.VK_UP  && playerPosY > 0){
                game.getField().getPlayer().move(0,-1);
                game.updateField(); //When up is pressed call the move method from player and the updateField method from field
                if(game.getField().finishReached()){
                    showFinishMessage(); //Check if the player has reached the finish after moving, if it is the case show a message
                }
                if(game.getField().checkBarricade(playerPosX, playerPosY - 1)){
                    showBarricadeMessage(); //Check if the player collides with a barricade, and doesnt have the right key. When the case show a message
                }
            } else if(e.getKeyCode() == KeyEvent.VK_R){
                try {
                    game.resetGame("src/doolhof/game/data/standardField.txt"); //When R is pressed, call the resetGame method in game, with a given txt file
                } catch (IOException ex) {
                   System.out.print("File not found");
                }
            }
        }
        
        /**
         * Empty overridable method
         * @param e Key that is pressed
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * Empty overridable method
         * @param e Key that is pressed
         */
        @Override
        public void keyPressed(KeyEvent e) {
        }  
        
    }
    
}
