package grafo;

import java.io.BufferedReader;
import java.io.FileReader;

public class Grafo {
  private int num_nodos;
  private int [][] distancias;
  private final int MAX_DIST = 100000;
  public int getNum_nodos() {
    return num_nodos;
  }
  public void setNum_nodos(int num_nodos) {
    this.num_nodos = num_nodos;
  }
  public int[][] getDistancias() {
    return distancias;
  }
  public void setDistancias(int x, int y, int dist) {
    distancias[x][y] = dist;
  }
  Grafo (String filename) {
    try{
      BufferedReader reader = new BufferedReader( new FileReader(filename));
      String [] temp;
      temp = reader.readLine ().split("[^\\d]+");
      setNum_nodos(Integer.parseInt(temp[0]));
      int [][] aux = new int [getNum_nodos()][getNum_nodos()];
      for (int i = 0)
      while (reader.ready()) {
        temp = reader.readLine ().split("[^\\d]+");
        setDistancias(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
      }
      reader.close();
    }catch (Exception e){
      System.err.println(e + "Error leyendo el fichero");
    }
  }
}
