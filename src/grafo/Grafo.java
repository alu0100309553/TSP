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
  public int getDistancia(int origen, int destino) {
    return distancias[origen][destino];
  }
  public void setDistancias(int x, int y, int dist) {
    distancias[x-1][y-1] = dist;
  }
  public Grafo (String filename) {
    try{
      BufferedReader reader = new BufferedReader( new FileReader(filename));
      String [] temp;
      temp = reader.readLine ().split("[^\\d]+");
      setNum_nodos(Integer.parseInt(temp[0]));
      distancias = new int [getNum_nodos()][getNum_nodos()];
      for (int i = 1; i<= getNum_nodos(); i++){
    	  for (int j = 1; j<= getNum_nodos(); j++){
    		  if (i==j){
    			  setDistancias(i, j, 0);
    		  }
    		  else{
    			  setDistancias(i, j, MAX_DIST);  
    		  }  
          }
      }
      while (reader.ready()) {
        temp = reader.readLine ().split("[^\\d]+");
        setDistancias(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        setDistancias(Integer.parseInt(temp[1]), Integer.parseInt(temp[0]), Integer.parseInt(temp[2]));
      }
      reader.close();
    }catch (Exception e){
      System.err.println(e + "Error leyendo el fichero");
    }
  }
}
