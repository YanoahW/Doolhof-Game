package doolhof.game;

/**
 * 
 * @author Yanoah Wiersma & Remon Turk
 * Groep: 3.6.2
 * Datum:
 * Versie:
 */
public class Game {
    private Field field;
    private boolean gameOver;
    
    public Game()
    {
        this.field = null;
        gameOver = false;
    }
    
    public Field getField()
    {
        return field;
    }
    
    public void setField(Field field)
    {
        this.field = field;
    }
<<<<<<< HEAD
=======
    
    public Field createField(String filename) throws FileNotFoundException, IOException
    {
      BufferedReader br = new BufferedReader(new FileReader(filename));
      String[] firstLine = br.readLine().split(" ");
      
      int rows = Integer.parseInt(firstLine[0]);
      int columns = Integer.parseInt(firstLine[1]);
      
      Field newField = new Field(rows, columns);
      
      for (int i = 0; i < rows; i++) {
          String[] nextLine = br.readLine().split(" ");
          
          for (int j = 0; j < columns; j++) {
              if (nextLine[j].equals("WWWW")) {
                  newField.setFieldItem(i, j, new Wall());
              } else if (nextLine[j].equals("FFFF")) {
                  newField.setFieldItem(i, j, new Finish());
              } else if (nextLine[j].startsWith("K")) {
                  String value = nextLine[j].substring(1); 
                  while (value.startsWith("0")) {
                      value = value.substring(1);
                  }
                  Key key = new Key(Integer.parseInt(value));
                  newField.setFieldItem(i, j, key);
              } else if (nextLine[j].startsWith("B")) {
                  String value = nextLine[j].substring(1);
                  while (value.startsWith("0")) {
                      value = value.substring(1);
                  }
                  Barricade barricade = new Barricade(Integer.parseInt(value));
                  newField.setFieldItem(i, j, barricade);
              } else if (nextLine[j].equals("PPPP")) {
                  Player player = new Player(i, j);
                  newField.setPlayer(player);
              } 
          }
      }
      
      return newField;
    }
    

>>>>>>> 044fbe509d5729545909b2a870934ca7af556fed
}
