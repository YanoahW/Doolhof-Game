package doolhof.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    
    public Field(int rows, int columns) throws IOException
    {
        this.rows = rows ;
        this.columns = columns;
        this.gridGame = new Tile[rows][columns];
        this.player = null;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.gridGame[i][j] = new Tile(null);
            }
        }
    }
    
    public void setPlayer(Player player) 
    {
        this.player = player;
    }
    
    public void setFieldItem(int row, int column, Item item)
    {
        this.gridGame[row][column].setItem(item);
    }
    
    public void setUpField(String filename) throws FileNotFoundException, IOException
    {
      BufferedReader bf = new BufferedReader(new FileReader(filename));
      String[] firstLine = bf.readLine().split(" ");
      
      rows = Integer.parseInt(firstLine[0]);
      columns = Integer.parseInt(firstLine[1]);
      
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
                  Player player = new Player(i, j);
                  this.setPlayer(player);
              } 
          }
      }
    }
    
    
    
    
}
