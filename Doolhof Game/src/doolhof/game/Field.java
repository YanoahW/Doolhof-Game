package doolhof.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that generates a Field, sets up a field and handles the collision between the player and the items
 * @author Yanoah Wiersma & Remon Turk
 * Group: 3.6.2
 * Date: 21-03-2018 t/m 02-04-2018
 * Version: 1.0
 */
public class Field {
    private Player player;
    private Tile[][] gridGame;
    private int rows;
    private int columns;
    private int cellsize;
    
    /**
     * Constructs a field object with a given rows, columns and cellsize
     * @param rows Number of rows in the field
     * @param columns Number of columns in the field
     * @param cellsize The size of each cell in the field
     */
    public Field(int rows, int columns, int cellsize)
    {
        this.rows = rows;
        this.columns = columns;
        this.gridGame = new Tile[rows][columns];
        this.player = null;
        this.cellsize = cellsize;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.gridGame[i][j] = new Tile(null); //fill each element(Tile) in the array with an empty item
            }
        }
    }
    
    /**
     * Gets the current player on the field
     * @return Returns a player object
     */
    public Player getPlayer(){
        return player;
    }
    
    /**
     * Sets the current player on the field
     * @param player Payer which has to be set on the field
     */
    public void setPlayer(Player player) 
    {
        this.player = player;
    }
    
    /**
     * Gets the current playfield which is called gridGame
     * @return returns a 2D array with all the Tiles and their items
     */
    public Tile[][] getGridGame(){
        return gridGame;
    }
    
    /**
     * Gets the amount of rows of the field
     * @return Returns an int, which is the number of rows
     */
    public int getRows(){
        return rows;
    }
    
    /**
     * Gets the amount of columns of the field
     * @return Returns an int, which is the number of columns
     */
    public int getColumns(){
        return columns;
    }
    
    /**
     * Gets the size of each cell in the field
     * @return Returns an int, which is the size of each cell
     */
    public int getCellSize(){
        return cellsize;
    }
    
    /**
     * Method that checks if there is a item on a given Tile, which the player would collide with
     * @param x The x position of the tile
     * @param y The y position of the tile
     * @return Returns a boolean, which is false when a player is able to move and true when the player cannot move
     */
    public boolean checkCollision(int x, int y){
        Tile tile = gridGame[y][x];
        if(tile.isWall()){
            return true; //Return true when colliding with a Wall object
        } else if(tile.isKey()){
            return false; //Return false when colliding with a Wall object
        } else if(tile.isBarricade()){
            Barricade barricade = (Barricade) tile.getItem();
            if(player.hasKey()){
                if(barricade.checkKey(player.getKey())){
                    return false; //Return false when colliding with a Barricade object, and the player having the right key, which means he can move
                }
            }
            return true; //Return true when the player doesn't have the right key, and thus cannot move
        } 
        return false; //When a field has no item, the player can move, so false is returned
    }
    
    /**
     * Method that takes care of everything that has to happen when a player picks up a key or destroys a barricade with it
     * @param x The x position of the tile
     * @param y The y position of the tile
     */
    public void handleCollision(int x, int y){
        Tile tile = gridGame[y][x];
        if(tile.isKey()){
        player.pickUpKey((Key) tile.getItem()); //Let the player pickup a key, when there is a key
        clearFieldItem(x,y); //Clear the tile
        } else if(tile.isBarricade()){
            Barricade barricade = (Barricade) tile.getItem();
            if(player.hasKey()){
                if(barricade.checkKey(player.getKey())){
                    clearFieldItem(x,y); //If the player has the right key, clear the tile
                } else{
                }
            }
        } 
    }
    
    /**
     * Method that checks if there is a Barricade located at the given x and y position
     * @param x The x position of the tile
     * @param y The y position of the tile
     * @return Returns a boolean true when there is a Barricade, else false is returned
     */
    public boolean checkBarricade(int x, int y){
        return gridGame[y][x].isBarricade();
    }
    
        /**
     * Method that checks if there is a Finish located at the given x and y position
     * @param x The x position of the tile
     * @param y The y position of the tile
     * @return Returns a boolean true when there is a Finish, else false is returned
     */
    public boolean checkFinish(int x, int y){
        return gridGame[y][x].isFinish();
    }
    
    /**
     * Method that checks if the current player has reached the finish
     * @return Returns a boolean true when the player has reached the finish, else false is returned
     */
    public boolean finishReached(){
        return (checkFinish(player.getPosX(), player.getPosY()));
    }
    
    /**
     * Sets a item on an element in the 2D-array gridGame
     * @param row Row in which the item is placed
     * @param column Column in which the item is placed
     * @param item Item that has to be placed on the tile
     */
    public void setFieldItem(int row, int column, Item item){
        this.gridGame[row][column].setItem(item);
    }
    
    /**
     * Clears a field in the game, the item on the element in de 2D-array gridGame is removed
     * @param x The x position of the item to be removed
     * @param y The y position of the item to be removed
     */
    public void clearFieldItem(int x, int y){
        gridGame[y][x].setItem(null);
    }
    
    /**
     * Initializes the gridGame 2D-array based on a txt input file
     * @param filename The filename of the file with the initial game layout
     * @throws IOException When the file cannot be found, an IOException is thrown
     */
    public void setUpField(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename)); //Start up a net BufferedReader to read the input
        for (int i = 0; i < rows; i++) {
            String[] nextLine = br.readLine().split(" "); //Split each line based on a space
            for (int j = 0; j < columns; j++) {
                if (nextLine[j].equals("WWWW")) {
                    this.setFieldItem(i, j, new Wall()); //When "WWWW" is found, the value at the indexes is set to a Wall object
                } else if (nextLine[j].equals("FFFF")) {
                    this.setFieldItem(i, j, new Finish()); //When "FFFF" is found, the value at the indexes is set to a Finish object
                } else if (nextLine[j].startsWith("K")) { 
                    String value = nextLine[j].substring(1); 
                    while (value.startsWith("0")) {
                        value = value.substring(1); //When "K" is found, the BufferedReader reads the value of the lock by looking at substrings
                    }
                    Key key = new Key(Integer.parseInt(value)); //A Key object is being created and set to the tile in the array
                    this.setFieldItem(i, j, key);
                } else if (nextLine[j].startsWith("B")) {
                    String value = nextLine[j].substring(1);
                    while (value.startsWith("0")) {
                        value = value.substring(1); 
                    }
                    Barricade barricade = new Barricade(Integer.parseInt(value)); //When "B" is found, the BufferedReader reads the value of the pincode by looking at substrings
                    this.setFieldItem(i, j, barricade); //A Barricade object is being created and set to the tile in the array
                } else if (nextLine[j].equals("PPPP")) {
                    Player player = new Player(j, i);
                    this.setPlayer(player); //When "PPPP" is found, a Player is created with the given indexes
                }
            }
        }
    } 
}
