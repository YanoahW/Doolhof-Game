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
    
    public boolean checkCollision(int x, int y){
        Tile tile = gridGame[y][x];
        if(tile.isWall()){
            return true;
        } else if(tile.isKey()){
            return false;
        } else if(tile.isBarricade()){
            Barricade barricade = (Barricade) tile.getItem();
            if(player.hasKey()){
                if(barricade.checkKey(player.getKey())){
                    return false;
                }
            }
            return true;
        } 
        return false;
    }
    
    public void handleCollision(int x, int y){
        Tile tile = gridGame[y][x];
        if(tile.isKey()){
        player.pickUpKey((Key) tile.getItem());
        clearFieldItem(x,y);
        } else if(tile.isBarricade()){
            Barricade barricade = (Barricade) tile.getItem();
            if(player.hasKey()){
                if(barricade.checkKey(player.getKey())){
                    clearFieldItem(x,y);
                } else{
                }
            }
        } 
    }
    
    public boolean checkFinish(int x, int y){
        if(gridGame[y][x].getItem() instanceof Finish){
            return true;
        }
        return false;
    }
    
    public void setFieldItem(int row, int column, Item item){
        this.gridGame[row][column].setItem(item);
    }
    
     public void clearFieldItem(int x, int y){
        gridGame[y][x].setItem(null);
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
