package doolhof.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class Field {
    private Player player;
    private Tile[][] gridGame;
    private int rows;
    private int columns;
    private int cellsize;
    private boolean finishFound;
    
    public Field(int rows, int columns, int cellsize) throws IOException
    {
        this.rows = rows;
        this.columns = columns;
        this.gridGame = new Tile[rows][columns];
        this.player = null;
        this.cellsize = cellsize;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.gridGame[i][j] = new Tile(null);
            }
        }
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public void setPlayer(Player player) 
    {
        this.player = player;
    }
    
    public Tile[][] getGridGame(){
        return gridGame;
    }
     
    public int getRows(){
        return rows;
    }
    
    public int getColumns(){
        return columns;
    }
    
    public int getCellSize(){
        return cellsize;
    }
    
    public boolean getFinishFound(){
        return finishFound;
    }
    
    public boolean checkCollision(int x, int y){
        if(gridGame[y][x].getItem() instanceof Wall){
            return true;
        } else if(gridGame[y][x].getItem() instanceof Key){
            player.pickUpKey((Key) gridGame[y][x].getItem());
            this.setFieldItem(y, x, null);
            return false;
        } else if(gridGame[y][x].getItem() instanceof Barricade){
            Barricade barricade = (Barricade) gridGame[y][x].getItem();
            if(player.getKey() != null){
                if(barricade.checkKey(player.getKey())){
                    this.setFieldItem(y, x, null);
                    return false;
                } else{
                    return true;
                }
            }
            return true;
        } 
        else{
            return false;
        }
    }
    
    public boolean checkFinish(int x, int y){
        if(gridGame[y][x].getItem() instanceof Finish){
            finishFound = true;
            return true;
        }
        return false;
    }
    
    public void setFieldItem(int row, int column, Item item){
        this.gridGame[row][column].setItem(item);
    }
    
    public void setUpField(String filename) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        for (int i = 0; i < rows; i++) {
            String[] nextLine = bf.readLine().split(" ");
            for (int j = 0; j < columns; j++) {
                if (nextLine[j].equals("WWWW")) {
                    this.setFieldItem(i, j, new Wall());
                } else if (nextLine[j].equals("FFFF")) {
                    this.setFieldItem(i, j, new Finish());
                } else if (nextLine[j].startsWith("K")) {
                    String value = nextLine[j].substring(1); 
                    while (value.startsWith("0")) {
                        value = value.substring(1);
                    }
                    Key key = new Key(Integer.parseInt(value));
                    this.setFieldItem(i, j, key);
                } else if (nextLine[j].startsWith("B")) {
                    String value = nextLine[j].substring(1);
                    while (value.startsWith("0")) {
                        value = value.substring(1);
                    }
                    Barricade barricade = new Barricade(Integer.parseInt(value));
                    this.setFieldItem(i, j, barricade);
                } else if (nextLine[j].equals("PPPP")) {
                    Player player = new Player(j, i);
                    this.setPlayer(player);
                }
            }
        }  
    }
}
